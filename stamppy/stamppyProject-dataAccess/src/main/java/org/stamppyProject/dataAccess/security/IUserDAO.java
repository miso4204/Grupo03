package org.stamppyProject.dataAccess.security;

import org.stamppyProject.model.security.User;


public interface IUserDAO {
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public User getUser(Long id);
	
	public User getLoginUser(String username, String password);
	
	
}
