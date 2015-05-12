package org.stamppyProject.dataAccess.business.rating;

import java.util.List;

import org.stamppyProject.model.business.Rating;

public interface IRatingDAO {
	
	public void saveRating(Rating rating);
	
	public void updateRating(Rating rating);
	
	public Rating getRatingByStamp(Long id);
	
	public Rating getRatingByProduct(Long id);
	
	public List<Rating> getRatingP(Double lowerBound, Double upperBound);
	
	public List<Rating> getRatingS(Double lowerBound, Double upperBound);
	
	public List<Rating> getAllRatingStamps();
	
	public List<Rating> getAllRatingStampsByArtist(Long artistId);
}
