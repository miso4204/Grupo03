package org.stamppyProject.dataAccess.security;

import java.util.List;

import org.stamppyProject.model.security.User;


public interface IUserDAO {
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public User getUser(Long id);
	
	public User getLoginUser(String username, String password);
	
	public User getUser(String username);
	
	public List<User> getArtist();
	
	
}
