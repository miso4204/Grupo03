package org.stamppyProject.dataAccess.business.cart;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.enumerations.CartStatusEnum;
import org.stamppyProject.model.security.User;

@Stateless
public class CartDAO implements ICartDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void saveCart(Cart cart) {
		em.persist(cart);
	}
	
	@Override
	public void updateCart(Cart cart) {
		em.merge(cart);	
	}
	
	public Cart getTempCart(User user){
		return (Cart)em.createNamedQuery("Cart.findCartByUserStatus")
				.setParameter("user", user)
				.setParameter("status", CartStatusEnum.TEMP)
				.getSingleResult();
	}
	
	@Override
	public Cart getCart(Long id) {
		return em.find(Cart.class, id);
	}
}
