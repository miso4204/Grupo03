package org.stamppyProject.businessLogic.business.stamp.dto;

import java.util.List;


public class StampJson {
	
	private Long id;
	
	private String name;

	private Double price;
	
	private String url;

	private List<String> keyWords;
	
	private Long artistId;
	
	private String artistName;
	
	private RatingJson rating;
	
	private Double offerPrice;
	

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
	 * @return the artistId
	 */
	public Long getArtistId() {
		return artistId;
	}

	/**
	 * @param artistId the artistId to set
	 */
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the rating
	 */
	public RatingJson getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(RatingJson rating) {
		this.rating = rating;
	}

	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return artistName;
	}

	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * @return the offerPrice
	 */
	public Double getOfferPrice() {
		return offerPrice;
	}

	/**
	 * @param offerPrice the offerPrice to set
	 */
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	
	
	
}
