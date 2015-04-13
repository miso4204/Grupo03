package org.stamppyProject.businessLogic.security;

import org.stamppyProject.businessLogic.security.dto.UserJson;


public interface IUser {
	
	public void registerUser(UserJson userJson);
	
	public void updateUser(UserJson userJson);
	
	public UserJson getSUser(Long id);

}
