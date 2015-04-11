package org.stamppyProject.businessLogic.business.cart.dto;

import java.util.List;

import org.stamppyProject.businessLogic.business.product.dto.ProductJson;

public class CartJson {
	
	private Long id;
	
	private List<ProductJson> products;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the products
	 */
	public List<ProductJson> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductJson> products) {
		this.products = products;
	}
	
	
	
}
