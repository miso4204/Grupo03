package org.stamppyProject.businessLogic.security.mapper;

import org.stamppyProject.businessLogic.security.dto.UserJson;
import org.stamppyProject.model.security.User;

public class UserJsonMapper {
	
	public static User convertToUser(UserJson userJson){
		
		User user = new User();
		user.setId(userJson.getId());
		user.setEmail(userJson.getEmail());
		user.setLastName(userJson.getLastName());
		user.setName(userJson.getName());
		user.setPassword(userJson.getPassword());
		user.setUsername(userJson.getUsername());	
		user.setUserType(userJson.getUserType());
		
		return user;
	}
	
	public static UserJson convertToUserJson(User user){
		
		UserJson userJson = new UserJson();
		userJson.setId(user.getId());
		userJson.setEmail(user.getEmail());
		userJson.setLastName(user.getLastName());
		userJson.setName(user.getName());
		userJson.setPassword(user.getPassword());
		userJson.setUsername(user.getUsername());	
		userJson.setUserType(user.getUserType());
		
		return userJson;
	}
}
