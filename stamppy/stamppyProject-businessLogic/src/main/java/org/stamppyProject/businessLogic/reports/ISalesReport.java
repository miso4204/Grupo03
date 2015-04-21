package org.stamppyProject.businessLogic.reports;

import java.util.Date;

import org.stamppyProject.businessLogic.reports.dto.SalesJsonList;

public interface ISalesReport {
	
	public SalesJsonList getSalesByPeriod(Date lowerBound, Date upperBound);
	
	public SalesJsonList getSalesByArtist(Long artistId);

}
