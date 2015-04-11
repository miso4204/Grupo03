package org.stamppyProject.businessLogic.security;

import javax.ejb.Local;

import org.stamppyProject.businessLogic.security.dto.UserJson;


public interface IUser {
	
	public void registerUser(UserJson userJson);

}
