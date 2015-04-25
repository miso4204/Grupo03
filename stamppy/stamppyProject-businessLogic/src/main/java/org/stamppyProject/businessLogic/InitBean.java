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

	
	
	
	@PostConstruct
	public void init(){
		rateProducts = RATE_PRODUCTS;
		rateDesigns = RATE_DESIGNS;
		userBuilder = USER_BUILDER_STRATEGY;
		reportRatingDesignArtist = REPORT_DESIGN_ARTIST;
		reportSalesArtist = REPORT_SALES_ARTIST;
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

	

}
