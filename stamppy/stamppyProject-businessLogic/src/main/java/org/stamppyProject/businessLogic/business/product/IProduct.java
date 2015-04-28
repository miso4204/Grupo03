package org.stamppyProject.businessLogic.business.product;

import java.util.List;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.product.dto.ProductsByRatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;

public interface IProduct {
	
	public void insertProduct(ProductJson productJson);
	
	public ProductJson getProduct(Long id);
	
	public void setRating(RatingJson ratingJson);
	
	public ProductsByRatingJson getByRatings(Double lowerBound, Double upperBound);
	
	public List<ProductJson> getAllProducts();
	
	public ProductJson insertProductAdmin(ProductJson productJson);

}
