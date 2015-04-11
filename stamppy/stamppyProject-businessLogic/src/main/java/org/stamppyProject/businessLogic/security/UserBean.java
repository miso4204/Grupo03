package org.stamppyProject.businessLogic.security;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.security.dto.UserJson;
import org.stamppyProject.businessLogic.security.mapper.UserJsonMapper;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.security.User;

@Stateless
public class UserBean implements IUser{
	
	@EJB(name="userDAO")
	private IUserDAO userDAO;
	
	@Override
	public void registerUser(UserJson userJson) {
		User user = UserJsonMapper.convertToUser(userJson);
		userDAO.insertUser(user);
	}
	
}
