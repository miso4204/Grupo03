package org.stamppyProject.businessLogic.business.stamp;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;

public interface IStamp {
	
	public void saveStamp(StampJson stampJson);
	
	public StampJson getStamp(Long id);
	
	public AvailableStampsJson getAvailableStamps();
	
	public void setStampNotAvailable(Long id);
	
	public void updateStamp(StampJson stampJson);
	
	public void setRating(RatingJson ratingJson);

}
