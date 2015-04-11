package org.stamppyProject.businessLogic.business.product.dto;

import org.stamppyProject.model.enumerations.ColorEnum;
import org.stamppyProject.model.enumerations.SizeEnum;


public class ProductJson {
	
	private Long id;
	
	private Long stampId;
	
	private Double price;
	
	private Double shippingPrice;

	private SizeEnum size;

	private ColorEnum color;
	
	private String url;
	
	private String text;

	private Long userId;

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
	 * @return the stampId
	 */
	public Long getStampId() {
		return stampId;
	}

	/**
	 * @param stampId the stampId to set
	 */
	public void setStampId(Long stampId) {
		this.stampId = stampId;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the shippingPrice
	 */
	public Double getShippingPrice() {
		return shippingPrice;
	}

	/**
	 * @param shippingPrice the shippingPrice to set
	 */
	public void setShippingPrice(Double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	/**
	 * @return the size
	 */
	public SizeEnum getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(SizeEnum size) {
		this.size = size;
	}

	/**
	 * @return the color
	 */
	public ColorEnum getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(ColorEnum color) {
		this.color = color;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
