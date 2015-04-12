package org.stamppyProject.dataAccess.business.rating;

import org.stamppyProject.model.business.Rating;

public interface IRatingDAO {
	
	public void saveRating(Rating rating);
	
	public void updateRating(Rating rating);
	
	public Rating getRating(Long id);
}
