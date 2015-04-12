package org.stamppyProject.businessLogic.business.cart;

import org.stamppyProject.businessLogic.business.cart.dto.CartJson;

public interface ICart {
	
	public CartJson getTempCart(Long userId);
	
	public void removeItem(Long cartId, Long productId);
}
