package business.DTO;

import java.util.List;

import org.stamppyProject.model.business.Tshirt;

public class TotalProductJsonDTO {
	
	private Integer total;
	
	private List<Product> products;

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public class Product{
		
		private Long productId;
		
		private String name;
		
		private Double price;
		
		private Double averageRating;
		
		private Integer ratings;
		
		private List<AvailableColors> availableColors;
		
		private List<AvailableSizes> availableSizes;
		
		private Double shippingPrice;
		
		private String imgUrl;
		
		private List<String> keyWords;

		/**
		 * @return the productId
		 */
		public Long getProductId() {
			return productId;
		}

		/**
		 * @param productId the productId to set
		 */
		public void setProductId(Long productId) {
			this.productId = productId;
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
		 * @return the averageRating
		 */
		public Double getAverageRating() {
			return averageRating;
		}

		/**
		 * @param averageRating the averageRating to set
		 */
		public void setAverageRating(Double averageRating) {
			this.averageRating = averageRating;
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
		 * @return the imgUrl
		 */
		public String getImgUrl() {
			return imgUrl;
		}

		/**
		 * @param imgUrl the imgUrl to set
		 */
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
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
		 * @return the ratings
		 */
		public Integer getRatings() {
			return ratings;
		}

		/**
		 * @param ratings the ratings to set
		 */
		public void setRatings(Integer ratings) {
			this.ratings = ratings;
		}
		
		
		
	}
	
	public class AvailableColors{
		private String name;
		
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
	}
	
	public class AvailableSizes{
		private String name;

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
		
		
	}
	

}
