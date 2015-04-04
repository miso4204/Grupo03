package org.stamppyProject.model.business;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

import org.stamppyProject.model.enumerations.ColorEnum;
import org.stamppyProject.model.enumerations.SizeEnum;
import org.stamppyProject.model.security.User;

/**
 * Entity implementation class for Entity: Camisa
 *
 */
@Entity

public class Tshirt implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	
	private SizeEnum size;
	
	private ColorEnum color;
	
	private String text;
	
	private Double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User seller;
	
	private static final long serialVersionUID = 1L;

	public Tshirt() {
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
	public SizeEnum getSize() {
		return this.size;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}   
	public ColorEnum getColor() {
		return this.color;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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
