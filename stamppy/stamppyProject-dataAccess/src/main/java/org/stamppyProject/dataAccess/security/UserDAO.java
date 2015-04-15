package org.stamppyProject.dataAccess.security;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	@Override
	public User getLoginUser(String username, String password) {
		try {
			return (User)em.createNamedQuery("user.findByUsernamePassword")
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	@Override
	public User getUser(String username) {
		try {
			return (User)em.createNamedQuery("user.findByUsername")
					.setParameter("username", username)
					.getSingleResult();
					
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
