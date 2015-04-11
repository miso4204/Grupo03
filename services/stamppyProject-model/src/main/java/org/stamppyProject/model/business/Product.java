package org.stamppyProject.model.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.stamppyProject.model.security.User;

/**
 * Entity implementation class for Entity: Stamp
 *
 */
@Entity

public class Product implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private Stamp stamp;
	
	private Double price;
	
	private Double shippingPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToMany(mappedBy="products")
	private List<Cart> carts;
	
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}

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
	 * @return the stamp
	 */
	public Stamp getStamp() {
		return stamp;
	}

	/**
	 * @param stamp the stamp to set
	 */
	public void setStamp(Stamp stamp) {
		this.stamp = stamp;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the carts
	 */
	public List<Cart> getCarts() {
		return carts;
	}

	/**
	 * @param carts the carts to set
	 */
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
   
	
}
