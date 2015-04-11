package org.stamppyProject.businessLogic.business.cart.mapper;

import java.util.ArrayList;
import java.util.List;

import org.stamppyProject.businessLogic.business.cart.dto.CartJson;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.product.mapper.ProductJsonMapper;
import org.stamppyProject.model.business.Cart;
import org.stamppyProject.model.business.Product;

public class CartJsonMapper {
	
	public static CartJson convertToCartJson(Cart cart){
		CartJson cartJson = new CartJson();
		cartJson.setId(cart.getId());
		List<ProductJson> products = new ArrayList<ProductJson>();
		for(Product p:cart.getProducts()){
			ProductJson productJson = ProductJsonMapper.convertToProductJson(p);
			products.add(productJson);
		}
		cartJson.setProducts(products);
		return cartJson;
	}

}
