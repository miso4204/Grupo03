package org.stamppyProject.businessLogic.business.cart.dto;

import org.stamppyProject.model.enumerations.PaymentStatusEnum;
import org.stamppyProject.model.enumerations.PaymentTypeEnum;

public class PaymentJson {
	
	private Long id;
	
	private Long cartId;
	
	private Double price;
	
	private PaymentTypeEnum type;
	
	private PaymentStatusEnum status;

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
	 * @return the cartId
	 */
	public Long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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
	 * @return the type
	 */
	public PaymentTypeEnum getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PaymentTypeEnum type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public PaymentStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(PaymentStatusEnum status) {
		this.status = status;
	}
	
	
	
}
