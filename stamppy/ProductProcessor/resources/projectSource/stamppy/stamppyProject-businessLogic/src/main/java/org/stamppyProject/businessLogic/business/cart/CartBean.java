package org.stamppyProject.businessLogic.business.cart;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.InitBean;
import org.stamppyProject.businessLogic.business.cart.dto.CartJson;
import org.stamppyProject.businessLogic.business.cart.dto.PaymentJson;
import org.stamppyProject.businessLogic.business.cart.mapper.CartJsonMapper;
import org.stamppyProject.businessLogic.business.cart.mapper.PaymentJsonMapper;
import org.stamppyProject.dataAccess.business.cart.ICartDAO;
import org.stamppyProject.dataAccess.business.payment.IPaymentDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.business.Payment;
import org.stamppyProject.model.business.Product;
import org.stamppyProject.model.enumerations.CartStatusEnum;
import org.stamppyProject.model.enumerations.PaymentStatusEnum;
import org.stamppyProject.model.enumerations.PaymentTypeEnum;


@Stateless
public class CartBean implements ICart {
	
	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private ICartDAO cartDAO;
	
	@EJB
	private IPaymentDAO paymentDAO;
	
	@EJB
	private InitBean initBean;
	
	@Override
	public CartJson getTempCart(Long userId) {
		return CartJsonMapper.convertToCartJson(cartDAO.getTempCart(userDAO.getUser(userId)));
	}
	
	@Override
	public void removeItem(Long cartId, Long productId) {
		Cart cart = cartDAO.getCart(cartId);
		Product tmp = null;
		for(Product p:cart.getProducts()){
			if(p.getId().equals(productId)){
				tmp=p;
				break;
			}
		}
		cart.getProducts().remove(tmp);
		cartDAO.updateCart(cart);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public PaymentJson purchaseProducts(PaymentJson paymentJson) {
		Payment payment = PaymentJsonMapper.convertToPayment(paymentJson);
		payment.setCart(cartDAO.getCart(paymentJson.getCartId()));
		if(!PaymentTypeEnum.CASH_ON_DELIVERY.equals(payment.getType())){
			Date date = new Date();
			if(date.getSeconds() % 4 == 0){
				payment.setStatus(PaymentStatusEnum.REJECTED);
			}else{
				payment.setStatus(PaymentStatusEnum.APPROVED);
				payment.getCart().setStatus(CartStatusEnum.CHECKOUT);
				payment.getCart().setCheckoutDate(new Date());
				cartDAO.updateCart(payment.getCart());
				//Create a new temp user's cart 
				Cart cart = new Cart();
				cart.setStatus(CartStatusEnum.TEMP);
				cart.setUser(payment.getCart().getUser());
				cartDAO.saveCart(cart);
			}
		}else{
			payment.setStatus(PaymentStatusEnum.WAITING_FOR_PAYMENT);
			payment.getCart().setStatus(CartStatusEnum.WAITING_CAHS_ON_DELIVERY);
			cartDAO.updateCart(payment.getCart());
			//Create a new temp user's cart 
			Cart cart = new Cart();
			cart.setStatus(CartStatusEnum.TEMP);
			cart.setUser(payment.getCart().getUser());
			cartDAO.saveCart(cart);
		}
		
		paymentDAO.savePayment(payment);
		return PaymentJsonMapper.convertToPaymentJson(payment);
	}
	
	@Override
	public Boolean validatePaymentRestrictions(PaymentJson paymentJson) {
		if(!PaymentTypeEnum.CASH_ON_DELIVERY.equals(paymentJson.getType())
				|| (PaymentTypeEnum.CASH_ON_DELIVERY.equals(paymentJson.getType()) && initBean.getCashOnDelivery())){
			return true;
		}else{
			return false;
		}
	}
}
