package org.stamppyProject.businessLogic.reports.dto;

import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;

public class SalesJson {
	
	private Integer numberSales;
	
	private StampJson stamp;

	/**
	 * @return the numberSales
	 */
	public Integer getNumberSales() {
		return numberSales;
	}

	/**
	 * @param numberSales the numberSales to set
	 */
	public void setNumberSales(Integer numberSales) {
		this.numberSales = numberSales;
	}

	/**
	 * @return the stamp
	 */
	public StampJson getStamp() {
		return stamp;
	}

	/**
	 * @param stamp the stamp to set
	 */
	public void setStamp(StampJson stamp) {
		this.stamp = stamp;
	}
	
	

}
