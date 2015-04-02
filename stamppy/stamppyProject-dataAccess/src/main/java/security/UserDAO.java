package security;

import org.stamppyProject.model.security.User;

public interface UserDAO {
	
	public void register(User user);
	
	public void update(User user);
	
	public User logIn(String username, String password);
	
	
}
