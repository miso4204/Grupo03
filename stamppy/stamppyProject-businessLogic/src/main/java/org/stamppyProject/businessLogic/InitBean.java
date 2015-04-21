package org.stamppyProject.businessLogic;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class InitBean {
	
	/**Search strategy variability**/
	private static final Boolean SEARCH_RATE_PRODUCTS = Boolean.FALSE;
	
	private static final Boolean SEARCH_RATE_DESIGNS = Boolean.FALSE;
	
	private Boolean searchRateProducts;
	
	private Boolean searchRateDesigns;
	
	/**update user builder variability**/
	private static final String USER_BUILDER_COMPLETE = "COMPLETE";
	
	private static final String USER_BUILDER_NOT_EMAIL_NOT_PASSWORD = "NOT_EMAIL_NOT_PASSWORD";
	
	private static final String USER_BUILDER_NOT_EMAIL ="NOT_EMAIL";
	
	private static final String USER_BUILDER_NOT_PASSWORD ="NOT_PASSWORD";
	
	/**reports variability**/
	private static final Boolean REPORT_DESIGN_ARTIST = Boolean.FALSE;
	
	private static final Boolean REPORT_SALES_ARTIST = Boolean.FALSE;
	
	private Boolean reportRatingDesignArtist;
	
	private Boolean reportSalesArtist;

	
	private String userBuilder;
	
	@PostConstruct
	public void init(){
		searchRateProducts = SEARCH_RATE_PRODUCTS;
		searchRateDesigns = SEARCH_RATE_DESIGNS;
		userBuilder = USER_BUILDER_COMPLETE;
		reportRatingDesignArtist = REPORT_DESIGN_ARTIST;
		reportSalesArtist = REPORT_SALES_ARTIST;
	}

	/**
	 * @return the searchRateProducts
	 */
	public Boolean getSearchRateProducts() {
		return searchRateProducts;
	}

	/**
	 * @param searchRateProducts the searchRateProducts to set
	 */
	public void setSearchRateProducts(Boolean searchRateProducts) {
		this.searchRateProducts = searchRateProducts;
	}

	/**
	 * @return the searchRateDesigns
	 */
	public Boolean getSearchRateDesigns() {
		return searchRateDesigns;
	}

	/**
	 * @param searchRateDesigns the searchRateDesigns to set
	 */
	public void setSearchRateDesigns(Boolean searchRateDesigns) {
		this.searchRateDesigns = searchRateDesigns;
	}

	/**
	 * @return the userBuilder
	 */
	public String getUserBuilder() {
		return userBuilder;
	}

	/**
	 * @param userBuilder the userBuilder to set
	 */
	public void setUserBuilder(String userBuilder) {
		this.userBuilder = userBuilder;
	}

	/**
	 * @return the reportRatingDesignArtist
	 */
	public Boolean getReportRatingDesignArtist() {
		return reportRatingDesignArtist;
	}

	/**
	 * @param reportRatingDesignArtist the reportRatingDesignArtist to set
	 */
	public void setReportRatingDesignArtist(Boolean reportRatingDesignArtist) {
		this.reportRatingDesignArtist = reportRatingDesignArtist;
	}

	/**
	 * @return the reportSalesArtist
	 */
	public Boolean getReportSalesArtist() {
		return reportSalesArtist;
	}

	/**
	 * @param reportSalesArtist the reportSalesArtist to set
	 */
	public void setReportSalesArtist(Boolean reportSalesArtist) {
		this.reportSalesArtist = reportSalesArtist;
	}
	
	

}
