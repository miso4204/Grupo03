package org.stamppyProject.model.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
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
import javax.persistence.OneToOne;

import org.stamppyProject.model.enumerations.StampStatusEnum;
import org.stamppyProject.model.security.User;

/**
 * Entity implementation class for Entity: Stamp
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name="Stamp.findAll", query="Select s from Stamp s"),
@NamedQuery(name="Stamp.findByArtist", query="Select s from Stamp s where s.seller.id=:artistId"),
@NamedQuery(name="Stamp.findByStatus", query="Select s from Stamp s where s.status=:status")
})
public class Stamp implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	
	private Double price;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Rating rating;
	
	private String url;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name ="tags")
	private List<String> keyWords;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User seller;
	
	@Enumerated(EnumType.STRING)
	private StampStatusEnum status;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Offer offer;
	
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
	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the keyWords
	 */
	public List<String> getKeyWords() {
		return keyWords;
	}
	/**
	 * @param keyWords the keyWords to set
	 */
	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}
	/**
	 * @return the status
	 */
	public StampStatusEnum getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(StampStatusEnum status) {
		this.status = status;
	}
	/**
	 * @return the offer
	 */
	public Offer getOffer() {
		return offer;
	}
	/**
	 * @param offer the offer to set
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}	
	
	
   
}
