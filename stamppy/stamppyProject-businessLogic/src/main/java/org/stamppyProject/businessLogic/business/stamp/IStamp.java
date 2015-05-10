package org.stamppyProject.businessLogic.business.stamp;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.OfferJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;
import org.stamppyProject.model.business.Offer;

public interface IStamp {
	
	public void saveStamp(StampJson stampJson);
	
	public StampJson getStamp(Long id);
	
	public AvailableStampsJson getAvailableStamps();
	
	public void setStampNotAvailable(Long id);
	
	public void updateStamp(StampJson stampJson);
	
	public void setRating(RatingJson ratingJson);
	
	public AvailableStampsJson getByRatings(Double lowerBound, Double upperBound); 
	
	public AvailableStampsJson getStampsByArtist(Long id);
	
	public Offer saveOffer(OfferJson offerJson);
	
	public Offer updateOffer(OfferJson offerJson);

}
