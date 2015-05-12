package org.stamppyProject.model.business;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Offer
 *
 */
@Entity

public class Offer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private Integer discount = 0;
	
	private static final long serialVersionUID = 1L;

	public Offer() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}   
   
}
