package org.stamppyProject.model.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.stamppyProject.model.enumerations.PaymentStatusEnum;
import org.stamppyProject.model.enumerations.PaymentTypeEnum;

@Entity
@NamedQueries({
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
})
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Cart cart;
	

	private Double price;
	
	@Enumerated(EnumType.STRING)
	private PaymentTypeEnum type;
	
	@Enumerated(EnumType.STRING)
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
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
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
