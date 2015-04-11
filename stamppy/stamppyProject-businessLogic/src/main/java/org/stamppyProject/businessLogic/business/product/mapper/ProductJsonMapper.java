package org.stamppyProject.businessLogic.business.product.mapper;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
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
		productJson.setUserId(product.getUser().getId());
		return productJson;
	}
}
