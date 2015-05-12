package main.java;

import java.util.List;

public class FeatureFileConverter {
	
	private boolean rateProducts;
	
	private boolean rateDesigns;
	
	private boolean text;
	
	private boolean color;
	
	private boolean cashOnDelivery;
	
	private boolean changePassword;
	
	private boolean changeAddress;
	
	private boolean rating;
	
	private boolean designsByArtist;
	
	private boolean sales;
	
	private boolean byArtist;
	
	private boolean createPromo;
	
	private boolean updatePromo;
	
	private boolean scalability;
	
	private boolean facebook;
	
	private boolean twitter;
	
	private boolean performance;
	
	
	public FeatureFileConverter(List<String> features){
		for(String f:features){
			if(f.equals(FeatureEnum.ByArtist.toString())){
				byArtist = true;
				System.out.println("FUNCIONA MI PEEEZ");
			}else if(f.equals(FeatureEnum.CashOnDelivery.toString())){
				cashOnDelivery = true;
			}else if(f.equals(FeatureEnum.ChangeAddress.toString())){
				changeAddress = true;
			}else if(f.equals(FeatureEnum.ChangePassword.toString())){
				changePassword = true;
			}else if(f.equals(FeatureEnum.Color.toString())){
				color = true;
			}else if(f.equals(FeatureEnum.CreatePromo.toString())){
				createPromo = true;
			}else if(f.equals(FeatureEnum.DesingsByArtist.toString())){
				designsByArtist = true;
			}else if(f.equals(FeatureEnum.RateDesigns.toString())){
				rateDesigns = true;
			}else if(f.equals(FeatureEnum.RateProducts.toString())){
				rateProducts = true;
			}else if(f.equals(FeatureEnum.Rating.toString())){
				rating = true;
			}else if(f.equals(FeatureEnum.Sales.toString())){
				sales = true;
			}else if(f.equals(FeatureEnum.Text.toString())){
				text = true;
			}else if(f.equals(FeatureEnum.UpdatePromo.toString())){
				updatePromo = true;
			}else if(f.equals(FeatureEnum.Scalability.toString())){
				scalability = true;
			}else if(f.equals(FeatureEnum.Twitter.toString())){
				twitter = true;
			}else if(f.equals(FeatureEnum.Facebook.toString())){
				facebook = true;
			}else if(f.equals(FeatureEnum.Performance_5.toString())){
				performance = true;
			}
		}
	}

	/**
	 * @return the rateProducts
	 */
	public boolean isRateProducts() {
		return rateProducts;
	}

	/**
	 * @return the rateDesigns
	 */
	public boolean isRateDesigns() {
		return rateDesigns;
	}

	/**
	 * @return the text
	 */
	public boolean isText() {
		return text;
	}

	/**
	 * @return the color
	 */
	public boolean isColor() {
		return color;
	}

	/**
	 * @return the cashOnDelivery
	 */
	public boolean isCashOnDelivery() {
		return cashOnDelivery;
	}

	/**
	 * @return the changePassword
	 */
	public boolean isChangePassword() {
		return changePassword;
	}

	/**
	 * @return the changeAddress
	 */
	public boolean isChangeAddress() {
		return changeAddress;
	}

	/**
	 * @return the rating
	 */
	public boolean isRating() {
		return rating;
	}

	/**
	 * @return the designsByArtist
	 */
	public boolean isDesignsByArtist() {
		return designsByArtist;
	}

	/**
	 * @return the sales
	 */
	public boolean isSales() {
		return sales;
	}

	/**
	 * @return the byArtist
	 */
	public boolean isByArtist() {
		return byArtist;
	}

	/**
	 * @return the createPromo
	 */
	public boolean isCreatePromo() {
		return createPromo;
	}

	/**
	 * @return the updatePromo
	 */
	public boolean isUpdatePromo() {
		return updatePromo;
	}

	public boolean isScalability() {
		return scalability;
	}

	public boolean isFacebook() {
		return facebook;
	}

	public boolean isTwitter() {
		return twitter;
	}

	public boolean isPerformance() {
		return performance;
	}
	
	
	
}
