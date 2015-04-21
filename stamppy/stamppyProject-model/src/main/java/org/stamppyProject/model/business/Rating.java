package org.stamppyProject.model.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
@NamedQuery(name="Rating.findByStamp", query="Select r from Rating r where r.stamp.id=:stampId"),
@NamedQuery(name="Rating.findAllStamps", query="Select r from Rating r where r.stamp is not null order by r.averageRating desc"),
@NamedQuery(name="Rating.findAllStampsByArtist", query="Select r from Rating r where r.stamp is not null and r.stamp.seller.id=:artistId order by r.averageRating desc"),
@NamedQuery(name="Rating.findByProduct", query="Select r from Rating r where r.product.id=:productId"),
@NamedQuery(name="Rating.findProductsByBoundaries", query="Select r from Rating r where r.product is not null and r.averageRating>=:lowerBound and r.averageRating<=:upperBound"),
@NamedQuery(name="Rating.findStampByBoundaries", query="Select r from Rating r where r.stamp is not null and r.averageRating>=:lowerBound and r.averageRating<=:upperBound")
})
public class Rating implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private Double averageRating = 0.0;
	
	private Integer ratings = 0;
	
	@OneToOne(mappedBy="rating")
	private Stamp stamp;
	
	@OneToOne(mappedBy="rating")
	private Product product;

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

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	

}
