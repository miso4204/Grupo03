package org.stamppyProject.businessLogic.reports.dto;

import java.util.ArrayList;
import java.util.List;

public class SalesJsonList {
	
	private Integer numberStamps;
	
	private List<SalesJson> sales;

	/**
	 * @return the numberStamps
	 */
	public Integer getNumberStamps() {
		return numberStamps;
	}

	/**
	 * @param numberStamps the numberStamps to set
	 */
	public void setNumberStamps(Integer numberStamps) {
		this.numberStamps = numberStamps;
	}

	/**
	 * @return the sales
	 */
	public List<SalesJson> getSales() {
		if(sales==null){
			sales = new ArrayList<SalesJson>();
		}
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(List<SalesJson> sales) {
		this.sales = sales;
	}
	
	

}
