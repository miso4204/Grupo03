package org.stamppyProject.businessLogic.business.product.dto;

import java.util.List;

public class ProductsByRatingJson {
	
	private int productsNumber;
	
	private List<ProductJson> products;

	/**
	 * @return the productsNumber
	 */
	public int getProductsNumber() {
		return productsNumber;
	}

	/**
	 * @param productsNumber the productsNumber to set
	 */
	public void setProductsNumber(int productsNumber) {
		this.productsNumber = productsNumber;
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
