package org.stamppyProject.model.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.stamppyProject.model.enumerations.SizeEnum;

@Entity
@NamedQueries({
@NamedQuery(name="availableSizes.findByTshirt", query="SELECT a FROM AvailableSizes a where a.tshirt = :tshirt")
})
public class AvailableSizes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Tshirt tshirt;
	
	@Enumerated(EnumType.STRING)
	private SizeEnum size;

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
	 * @return the tshirt
	 */
	public Tshirt getTshirt() {
		return tshirt;
	}

	/**
	 * @param tshirt the tshirt to set
	 */
	public void setTshirt(Tshirt tshirt) {
		this.tshirt = tshirt;
	}

	/**
	 * @return the size
	 */
	public SizeEnum getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(SizeEnum size) {
		this.size = size;
	}
	
	
}
