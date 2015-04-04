package org.stamppyProject.model.business;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

import org.stamppyProject.model.security.User;

/**
 * Entity implementation class for Entity: Stamp
 *
 */
@Entity

public class Stamp implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	
	private String url;
	
	private Double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User seller;
	
	private static final long serialVersionUID = 1L;

	public Stamp() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}   
	public User getSeller() {
		return this.seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
   
}
