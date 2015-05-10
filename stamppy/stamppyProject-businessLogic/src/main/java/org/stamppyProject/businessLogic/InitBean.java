package org.stamppyProject.businessLogic;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class InitBean {
	
	/**Rating strategy variability**/
	private static final Boolean RATE_PRODUCTS = Boolean.TRUE;
	
	private static final Boolean RATE_DESIGNS = Boolean.TRUE;
	
	private Boolean rateProducts;
	
	private Boolean rateDesigns;
	
	/**update user builder variability**/
	private static final String USER_BUILDER_STRATEGY = "COMPLETE";
	
	private String userBuilder;
	
	/**reports variability**/
	private static final Boolean REPORT_DESIGN_ARTIST = Boolean.TRUE;
	
	private static final Boolean REPORT_SALES_ARTIST = Boolean.TRUE;
	
	private Boolean reportRatingDesignArtist;
	
	private Boolean reportSalesArtist;
	
	/**payment variability**/
	private static final Boolean CASH_ON_DELIVERY = Boolean.TRUE;
	private Boolean cashOnDelivery;
	
	
	/**socialnetwork variability**/
	
	private static final Boolean TWITTER = Boolean.TRUE;
	private static final Boolean FACEBOOK = Boolean.TRUE;
	private Boolean facebook;
	private Boolean twitter;

	
	
	
	@PostConstruct
	public void init(){
		rateProducts = RATE_PRODUCTS;
		rateDesigns = RATE_DESIGNS;
		userBuilder = USER_BUILDER_STRATEGY;
		reportRatingDesignArtist = REPORT_DESIGN_ARTIST;
		reportSalesArtist = REPORT_SALES_ARTIST;
		cashOnDelivery= CASH_ON_DELIVERY;
		facebook=FACEBOOK;
		twitter=TWITTER;
	}
	
	

	/**
	 * @return the rateProducts
	 */
	public Boolean getRateProducts() {
		return rateProducts;
	}


	/**
	 * @return the rateDesigns
	 */
	public Boolean getRateDesigns() {
		return rateDesigns;
	}


	/**
	 * @return the userBuilder
	 */
	public String getUserBuilder() {
		return userBuilder;
	}


	/**
	 * @return the reportRatingDesignArtist
	 */
	public Boolean getReportRatingDesignArtist() {
		return reportRatingDesignArtist;
	}


	/**
	 * @return the reportSalesArtist
	 */
	public Boolean getReportSalesArtist() {
		return reportSalesArtist;
	}



	/**
	 * @return the cashOnDelivery
	 */
	public Boolean getCashOnDelivery() {
		return cashOnDelivery;
	}



	/**
	 * @return the facebook
	 */
	public Boolean getFacebook() {
		return facebook;
	}



	/**
	 * @return the twitter
	 */
	public Boolean getTwitter() {
		return twitter;
	}

	
	

}
