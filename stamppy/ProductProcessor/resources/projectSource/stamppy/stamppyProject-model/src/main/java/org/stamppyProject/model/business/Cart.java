package org.stamppyProject.model.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.stamppyProject.model.enumerations.CartStatusEnum;
import org.stamppyProject.model.security.User;

@Entity
@NamedQueries({
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c"),
@NamedQuery(name="Cart.findCartByUserStatus", query="SELECT c FROM Cart c where c.user =:user and c.status =:status")
})
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Cart_Product")
	private List <Product> products;
	
	@OneToOne(mappedBy="cart")
	private Payment payment;
	
	@Enumerated(EnumType.STRING)
	private CartStatusEnum status;
	
	private Date checkoutDate;

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
	 * @return the products
	 */
	public List<Product> getProducts() {
		if(products==null){
			products = new ArrayList<Product>();
		}
		return products;
	}


	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}


	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}


	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	/**
	 * @return the status
	 */
	public CartStatusEnum getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(CartStatusEnum status) {
		this.status = status;
	}


	/**
	 * @return the checkoutDate
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}


	/**
	 * @param checkoutDate the checkoutDate to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	
	
}
