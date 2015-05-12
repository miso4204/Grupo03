package org.stamppyProject.businessLogic.business.stamp.dto;


public class RatingJson {
	
	private Long id;
	
	private Double averageRating;
	
	private Integer ratings;
	
	private Double calification;
	
	private Long stampId;
	
	private Long productId;

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
	 * @return the averageRating
	 */
	public Double getAverageRating() {
		return averageRating;
	}

	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	/**
	 * @return the ratings
	 */
	public Integer getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
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
	 * @return the calification
	 */
	public Double getCalification() {
		return calification;
	}

	/**
	 * @param calification the calification to set
	 */
	public void setCalification(Double calification) {
		this.calification = calification;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	
}
