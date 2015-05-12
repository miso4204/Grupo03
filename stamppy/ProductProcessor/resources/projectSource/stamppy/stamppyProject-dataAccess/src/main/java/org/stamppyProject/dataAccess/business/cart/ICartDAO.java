package org.stamppyProject.dataAccess.business.cart;

import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.security.User;

public interface ICartDAO {
	
	public void saveCart(Cart cart);
	
	public void updateCart(Cart cart);
	
	public Cart getTempCart(User user);
	
	public Cart getCart(Long id);
}
