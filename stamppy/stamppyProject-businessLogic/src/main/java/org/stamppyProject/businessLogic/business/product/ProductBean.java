package org.stamppyProject.businessLogic.business.product;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.product.dto.ProductsByRatingJson;
import org.stamppyProject.businessLogic.business.product.mapper.ProductJsonMapper;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.dataAccess.business.cart.ICartDAO;
import org.stamppyProject.dataAccess.business.product.IProductDAO;
import org.stamppyProject.dataAccess.business.rating.IRatingDAO;
import org.stamppyProject.dataAccess.business.stamp.IStampDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.business.Product;
import org.stamppyProject.model.business.Rating;

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
	
	@EJB
	private IRatingDAO ratingDAO;
	
	
	@Override
	public void insertProduct(ProductJson productJson) {
		Product product = ProductJsonMapper.convertToProduct(productJson);
		product.setStamp(stampDAO.getStamp(productJson.getStampId()));
		product.setUser(userDAO.getUser(productJson.getUserId()));
		productDAO.saveProduct(product);
		addProductToCart(product);
	}
	
	@Override
	public ProductJson getProduct(Long id) {
		return ProductJsonMapper.convertToProductJson(productDAO.getProduct(id));
		
	}
	
	@Override
	public void setRating(RatingJson ratingJson) {
		Rating rating = ratingDAO.getRatingByProduct(ratingJson.getProductId());
		if(rating!=null){
			rating.setRatings(rating.getRatings()+1);
			rating.setAverageRating((rating.getAverageRating()+ratingJson.getCalification())/rating.getRatings());
			ratingDAO.updateRating(rating);
		}else{
			rating = new Rating();
			rating.setAverageRating(ratingJson.getCalification());
			rating.setRatings(1);
			rating.setProduct(productDAO.getProduct(ratingJson.getProductId()));
			rating.getProduct().setRating(rating);
			ratingDAO.saveRating(rating);
			productDAO.updateProduct(rating.getProduct());
		}
		
	}
	
	@Override
	public ProductsByRatingJson getByRatings(Double lowerBound,
			Double upperBound) {
		List<Rating> ratings = ratingDAO.getRatingP(lowerBound, upperBound);
		List<Product> products = new ArrayList<Product>();
		for(Rating r:ratings){
			products.add(r.getProduct());
		}
		return ProductJsonMapper.convertToProductsByRatingJson(products);
	}
	
	private void addProductToCart(Product product){
		Cart cart = cartDAO.getTempCart(product.getUser());
		cart.getProducts().add(product);
		cartDAO.updateCart(cart);
	}
	
	
	
}
