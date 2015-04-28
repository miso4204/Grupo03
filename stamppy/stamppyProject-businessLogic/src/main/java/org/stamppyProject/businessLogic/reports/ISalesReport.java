package org.stamppyProject.businessLogic.reports;

import java.text.ParseException;

import org.stamppyProject.businessLogic.reports.dto.SalesJsonList;

public interface ISalesReport {
	
	public SalesJsonList getSalesByPeriod(String lowerBound, String upperBound) throws ParseException;
	
	public SalesJsonList getSalesByArtist(Long artistId);

}
