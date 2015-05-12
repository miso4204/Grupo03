package org.stamppyProject.businessLogic.security;

import org.stamppyProject.model.security.User;

public class UserBuilder {
	
	
	private static final String USER_BUILDER_COMPLETE = "COMPLETE";
	
	private static final String USER_BUILDER_NOT_EMAIL_NOT_PASSWORD = "NOT_EMAIL_NOT_PASSWORD";
	
	private static final String USER_BUILDER_NOT_EMAIL ="NOT_EMAIL";
	
	private static final String USER_BUILDER_NOT_PASSWORD ="NOT_PASSWORD";
	
	public static User updateUserBuilder(String builder, User newUser, User oldUser){
		if(builder.equals(USER_BUILDER_COMPLETE)){
			return newUser;
		}else if(builder.equals(USER_BUILDER_NOT_EMAIL_NOT_PASSWORD)){
			return notEmailNotPasswordBuilder(newUser, oldUser);
		}else if(builder.equals(USER_BUILDER_NOT_EMAIL)){
			return notEmailBuilder(newUser, oldUser);
		}else{
			return notPasswordBuilder(newUser, oldUser);
		}
	}
	
	private static User notEmailNotPasswordBuilder(User newUser, User oldUser){
		User user = new User();
		user.setId(newUser.getId());
		user.setEmail(oldUser.getEmail());
		user.setLastName(newUser.getLastName());
		user.setName(newUser.getName());
		user.setPassword(oldUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setUserType(newUser.getUserType());
		return user;
	}
	
	private static User notEmailBuilder(User newUser, User oldUser){
		User user = new User();
		user.setId(newUser.getId());
		user.setEmail(oldUser.getEmail());
		user.setLastName(newUser.getLastName());
		user.setName(newUser.getName());
		user.setPassword(newUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setUserType(newUser.getUserType());
		return user;
	}
	
	private static User notPasswordBuilder(User newUser, User oldUser){
		User user = new User();
		user.setId(newUser.getId());
		user.setEmail(newUser.getEmail());
		user.setLastName(newUser.getLastName());
		user.setName(newUser.getName());
		user.setPassword(oldUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setUserType(newUser.getUserType());
		return user;
	}

}
