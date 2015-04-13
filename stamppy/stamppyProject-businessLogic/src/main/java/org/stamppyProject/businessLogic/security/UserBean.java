package org.stamppyProject.businessLogic.security;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.stamp.Stamp;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;
import org.stamppyProject.businessLogic.business.stamp.mapper.StampJsonMapper;
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
	public void registerUser(UserJson userJson) {
		User user = UserJsonMapper.convertToUser(userJson);
		userDAO.insertUser(user);
		if(user.getUserType().equals(UserTypeEnum.CLIENT)){
			Cart cart = new Cart();
			cart.setUser(user);
			cart.setStatus(CartStatusEnum.TEMP);
			cartDAO.saveCart(cart);
		}
	}
	
	@Override
	public void updateUser(UserJson userJson) {
		User user = UserJsonMapper.convertToUser(userJson);		
		userDAO.updateUser(user);
	}
	
	@Override
	public UserJson getSUser(Long id) {
		return UserJsonMapper.convertToUser(userDAO.getUser(id));
	}	
}
