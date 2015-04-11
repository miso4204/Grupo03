package org.stamppyProject.businessLogic.business.product;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.product.mapper.ProductJsonMapper;
import org.stamppyProject.dataAccess.business.cart.ICartDAO;
import org.stamppyProject.dataAccess.business.product.IProductDAO;
import org.stamppyProject.dataAccess.business.stamp.IStampDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.business.Product;

@Stateless
public class ProductBean implements IProduct {

	@EJB
	private IProductDAO productDAO;
	
	@EJB
	private IStampDAO stampDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private ICartDAO cartDAO;
	
	@Override
	public void insertProduct(ProductJson productJson) {
		Product product = ProductJsonMapper.convertToProduct(productJson);
		product.setStamp(stampDAO.getStamp(productJson.getStampId()));
		product.setUser(userDAO.getUser(productJson.getUserId()));
		productDAO.saveProduct(product);
		addProductToCart(product);
	}
	
	private void addProductToCart(Product product){
		Cart cart = cartDAO.getTempCart(product.getUser());
		cart.getProducts().add(product);
		cartDAO.updateCart(cart);
	}
}
