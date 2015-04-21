package org.stamppyProject.businessLogic.business.stamp.mapper;

import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.model.business.Rating;

public class RatingJsonMapper {
	
	public static RatingJson convertToRatingJson(Rating rating){
		RatingJson ratingJson = new RatingJson();
		ratingJson.setAverageRating(rating.getAverageRating());
		ratingJson.setId(rating.getId());
		ratingJson.setRatings(rating.getRatings());
		ratingJson.setStampId(rating.getStamp()!=null ? rating.getStamp().getId():null);
		ratingJson.setProductId(rating.getProduct()!=null ? rating.getProduct().getId():null);
		return ratingJson;
	}

}
