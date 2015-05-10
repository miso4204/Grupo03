package org.stamppyProject.businessLogic.business.stamp.dto;

public class OfferJson {
	
	private Long id;
	
	private Integer discount;
	
	private Long stampId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * @return the stampId
	 */
	public Long getStampId() {
		return stampId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @param stampId the stampId to set
	 */
	public void setStampId(Long stampId) {
		this.stampId = stampId;
	}
	
	

}
