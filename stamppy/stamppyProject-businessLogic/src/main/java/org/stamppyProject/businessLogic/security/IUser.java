package org.stamppyProject.businessLogic.security;

import org.stamppyProject.businessLogic.MethodResponseEnum;
import org.stamppyProject.businessLogic.security.dto.UserJson;


public interface IUser {
	
	public MethodResponseEnum registerUser(UserJson userJson);
	
	public void updateUser(UserJson userJson);
	
	public UserJson login(UserJson userJson);
	
	public UserJson getUser(Long id);
	

}
