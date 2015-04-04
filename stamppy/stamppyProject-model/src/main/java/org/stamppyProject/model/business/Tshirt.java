package org.stamppyProject.model.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.stamppyProject.model.security.User;

/**
 * Entity implementation class for Entity: Tshirt
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name="tshirt.findAllAvailable", query="SELECT distinct t FROM Tshirt t join fetch t.seller left join fetch t.rating left join fetch t.keyWords")
})
public class Tshirt implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	
	private String text;
	
	private Double price;
	
	private Double shippingPrice;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Rating rating;
	
	private String url;
	
	@ElementCollection
	@CollectionTable(name ="tags")
	private List<String> keyWords;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="tshirt")
	private List<AvailableColors> availableColors;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="tshirt")
	private List<AvailableSizes> availableSizes;
	
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
	 * @return the availableColors
	 */
	public List<AvailableColors> getAvailableColors() {
		return availableColors;
	}
	/**
	 * @param availableColors the availableColors to set
	 */
	public void setAvailableColors(List<AvailableColors> availableColors) {
		this.availableColors = availableColors;
	}
	/**
	 * @return the availableSizes
	 */
	public List<AvailableSizes> getAvailableSizes() {
		return availableSizes;
	}
	/**
	 * @param availableSizes the availableSizes to set
	 */
	public void setAvailableSizes(List<AvailableSizes> availableSizes) {
		this.availableSizes = availableSizes;
	}
	
	
   
}
