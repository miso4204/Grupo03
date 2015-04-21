package org.stamppyProject.businessLogic.reports;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.mapper.StampJsonMapper;
import org.stamppyProject.dataAccess.business.rating.IRatingDAO;
import org.stamppyProject.model.business.Rating;
import org.stamppyProject.model.business.Stamp;

@Stateless
public class RatingReportBean implements IRatingReport{
	
	@EJB
	private IRatingDAO ratingDAO;
	
	@Override
	public AvailableStampsJson getAllRatingStamps() {
		List<Rating> ratings = ratingDAO.getAllRatingStamps();
		List<Stamp> stamps = new ArrayList<Stamp>();
		for(Rating r:ratings){
			stamps.add(r.getStamp());
		}
		return StampJsonMapper.convertToAvailableStampsJson(stamps);
	}
	
	@Override
	public AvailableStampsJson getAllRatingStampsByArtist(Long artistId) {
		List<Rating> ratings = ratingDAO.getAllRatingStampsByArtist(artistId);
		List<Stamp> stamps = new ArrayList<Stamp>();
		for(Rating r:ratings){
			stamps.add(r.getStamp());
		}
		return StampJsonMapper.convertToAvailableStampsJson(stamps);
	}

}
