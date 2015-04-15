package org.stamppyProject.businessLogic.security;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.MethodResponseEnum;
import org.stamppyProject.businessLogic.security.dto.UserJson;
import org.stamppyProject.businessLogic.security.mapper.UserJsonMapper;
import org.stamppyProject.dataAccess.business.cart.ICartDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.enumerations.CartStatusEnum;
import org.stamppyProject.model.enumerations.UserTypeEnum;
import org.stamppyProject.model.security.User;

@Stateless
public class UserBean implements IUser{
	
	@EJB(name="userDAO")
	private IUserDAO userDAO;
	
	@EJB
	private ICartDAO cartDAO;
	
	@Override
	public MethodResponseEnum registerUser(UserJson userJson) {
		User user = UserJsonMapper.convertToUser(userJson);
		User tmp = getUser(user.getUsername());
		if(tmp==null){
			userDAO.insertUser(user);
			if(user.getUserType().equals(UserTypeEnum.CLIENT)){
				Cart cart = new Cart();
				cart.setUser(user);
				cart.setStatus(CartStatusEnum.TEMP);
				cartDAO.saveCart(cart);
			}
			return MethodResponseEnum.OK;
		}else{
			return MethodResponseEnum.FAILED;
		}
	}
	
	@Override
	public void updateUser(UserJson userJson) {
		User user = UserJsonMapper.convertToUser(userJson);		
		userDAO.updateUser(user);
	}

	
	@Override
	public UserJson login(UserJson userJson) {
		User user = userDAO.getLoginUser(userJson.getUsername(), userJson.getPassword());
		if(user != null){
			return UserJsonMapper.convertToUserJson(user);
		}
		return null;
	}
	
	@Override
	public UserJson getUser(Long id) {
		return UserJsonMapper.convertToUserJson(userDAO.getUser(id));
	}
	
	private User getUser(String username){
		return userDAO.getUser(username);
	}
}
