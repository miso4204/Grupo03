package org.stamppyProject.businessLogic.business.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.product.dto.ProductsByRatingJson;
import org.stamppyProject.businessLogic.business.stamp.mapper.RatingJsonMapper;
import org.stamppyProject.model.business.Product;

public class ProductJsonMapper {
	
	public static Product convertToProduct(ProductJson productJson){
		Product product = new Product();
		product.setPrice(productJson.getPrice());
		product.setShippingPrice(productJson.getShippingPrice());
		product.setSize(productJson.getSize());
		product.setColor(productJson.getColor());
		product.setUrl(productJson.getUrl());
		product.setText(productJson.getText());
		return product;
	}
	
	public static ProductJson convertToProductJson(Product product){
		ProductJson productJson = new ProductJson();
		productJson.setId(product.getId());
		productJson.setPrice(product.getPrice());
		productJson.setShippingPrice(product.getShippingPrice());
		productJson.setSize(product.getSize());
		productJson.setColor(product.getColor());
		productJson.setUrl(product.getUrl());
		productJson.setText(product.getText());
		if(product.getRating()!=null)
			productJson.setRating(RatingJsonMapper.convertToRatingJson(product.getRating()));
		productJson.setUserId(product.getUser().getId());
		return productJson;
	}
	
	public static ProductsByRatingJson convertToProductsByRatingJson(List<Product> products){
		ProductsByRatingJson productsByRatingJson = new ProductsByRatingJson();
		if(products != null){
			productsByRatingJson.setProductsNumber(products.size());
			List<ProductJson> psj = new ArrayList<ProductJson>();
			for(Product p : products){
				ProductJson pj = new ProductJson();
				pj = convertToProductJson(p);
				psj.add(pj);
			}
			productsByRatingJson.setProducts(psj);
		}
		return productsByRatingJson;
	}
}
