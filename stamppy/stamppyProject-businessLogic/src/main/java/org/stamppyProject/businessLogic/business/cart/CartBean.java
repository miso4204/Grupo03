package org.stamppyProject.businessLogic.business.cart;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.cart.dto.CartJson;
import org.stamppyProject.businessLogic.business.cart.mapper.CartJsonMapper;
import org.stamppyProject.dataAccess.business.cart.ICartDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.business.Product;


@Stateless
public class CartBean implements ICart {
	
	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private ICartDAO cartDAO;
	
	@Override
	public CartJson getTempCart(Long userId) {
		return CartJsonMapper.convertToCartJson(cartDAO.getTempCart(userDAO.getUser(userId)));
	}
	
	@Override
	public void removeItem(Long cartId, Long productId) {
		Cart cart = cartDAO.getCart(cartId);
		Product tmp = null;
		for(Product p:cart.getProducts()){
			if(p.getId().equals(cartId)){
				tmp=p;
				break;
			}
		}
		cart.getProducts().remove(tmp);
		cartDAO.updateCart(cart);
	}

}
