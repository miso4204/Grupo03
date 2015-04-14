package org.stamppyProject.businessLogic.business.cart;

import org.stamppyProject.businessLogic.business.cart.dto.CartJson;
import org.stamppyProject.businessLogic.business.cart.dto.PaymentJson;

public interface ICart {
	
	public CartJson getTempCart(Long userId);
	
	public void removeItem(Long cartId, Long productId);
	
	public String purchaseProducts(PaymentJson payment);
}
