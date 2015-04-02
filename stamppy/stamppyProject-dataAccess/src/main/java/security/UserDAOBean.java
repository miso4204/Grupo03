package security;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.security.User;

@Stateful
public class UserDAOBean implements UserDAO{
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void register(User user) {
		em.persist(user);
		
	}
	
	@Override
	public void update(User user) {
		em.merge(user);
		
	}

	@Override
	public User logIn(String username, String password) {
		try {
			User u = (User)em.createNamedQuery("user.findByUsername")
					.setParameter("username", username)
					.getSingleResult();
			if(password.equals(u.getPassword()))
				return u;
			else
				return null;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
}
