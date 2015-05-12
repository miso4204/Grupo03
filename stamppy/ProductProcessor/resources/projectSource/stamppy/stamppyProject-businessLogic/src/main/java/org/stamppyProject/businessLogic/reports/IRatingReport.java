package org.stamppyProject.businessLogic.reports;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;

public interface IRatingReport {
	
	public AvailableStampsJson getAllRatingStamps();
	
	public AvailableStampsJson getAllRatingStampsByArtist(Long artistId);

}
