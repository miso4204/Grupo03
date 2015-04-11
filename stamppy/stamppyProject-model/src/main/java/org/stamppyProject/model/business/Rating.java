package org.stamppyProject.model.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rating implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private Double averageRating;
	
	private Integer ratings;
	
	@OneToOne(mappedBy="rating")
	private Stamp stamp;

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
	 * @return the stamp
	 */
	public Stamp getStamp() {
		return stamp;
	}

	/**
	 * @param tshirt the stamp to set
	 */
	public void setStamp(Stamp stamp) {
		this.stamp = stamp;
	}
	
	

}
