package org.stamppyProject.dataAccess.security;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.security.User;

@Stateless
public class UserDAO implements IUserDAO{
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	
	@Override
	public void insertUser(User user) {
		em.persist(user);
		
	}
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
		
	}
	
	@Override
	public void deleteUser(User user) {
		em.remove(user);
		
	}
	
	@Override
	public User getUser(Long id) {
		return em.find(User.class, id);
	}
	
}
