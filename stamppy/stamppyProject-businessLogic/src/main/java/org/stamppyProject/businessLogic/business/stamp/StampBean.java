package org.stamppyProject.businessLogic.business.stamp;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.annotations.OffersVariability;
import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.OfferJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;
import org.stamppyProject.businessLogic.business.stamp.mapper.StampJsonMapper;
import org.stamppyProject.dataAccess.business.rating.IRatingDAO;
import org.stamppyProject.dataAccess.business.stamp.IStampDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
import org.stamppyProject.model.business.Offer;
import org.stamppyProject.model.business.Rating;
import org.stamppyProject.model.business.Stamp;
import org.stamppyProject.model.enumerations.StampStatusEnum;

@Stateless
public class StampBean implements IStamp{
	
	@EJB
	private IStampDAO stampDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private IRatingDAO ratingDAO;
	
	@Override
	public void saveStamp(StampJson stampJson) {
		Stamp stamp = StampJsonMapper.convertToStamp(stampJson);
		stamp.setSeller(userDAO.getUser(stampJson.getArtistId()));
		stamp.setStatus(StampStatusEnum.AVAILABLE);
		Rating rating = new Rating();
		rating.setRatings(0);
		rating.setAverageRating(0.0);
		stamp.setRating(rating);
		ratingDAO.saveRating(rating);
		stampDAO.insertStamp(stamp);
	}
	
	@Override
	public void updateStamp(StampJson stampJson) {
		Stamp stamp = StampJsonMapper.convertToStamp(stampJson);
		stamp.setSeller(userDAO.getUser(stampJson.getArtistId()));
		stamp.setStatus(StampStatusEnum.AVAILABLE);
		stampDAO.updateStamp(stamp);
	}
	
	@Override
	public StampJson getStamp(Long id) {
		return StampJsonMapper.convertToStampJson(stampDAO.getStamp(id));
	}
	
	@Override
	public AvailableStampsJson getAvailableStamps() {
		return StampJsonMapper.convertToAvailableStampsJson(stampDAO.getAvailableStamps());
	}
	
	@Override
	public void setStampNotAvailable(Long id) {
		Stamp stamp = stampDAO.getStamp(id);
		stamp.setStatus(StampStatusEnum.NOT_AVAILABLE);
		stampDAO.updateStamp(stamp);
	}
	
	@Override
	public void setRating(RatingJson ratingJson) {
		Rating rating = ratingDAO.getRatingByStamp(ratingJson.getStampId());
		if(rating!=null){
			rating.setRatings(rating.getRatings()+1);
			rating.setAverageRating(((rating.getAverageRating()*rating.getRatings()-1)+ratingJson.getCalification())/rating.getRatings());
			ratingDAO.updateRating(rating);
		}else{
			rating = new Rating();
			rating.setAverageRating(ratingJson.getCalification());
			rating.setRatings(1);
			rating.setStamp(stampDAO.getStamp(ratingJson.getStampId()));
			rating.getStamp().setRating(rating);
			ratingDAO.saveRating(rating);
			stampDAO.updateStamp(rating.getStamp());
		}
		
	}
	
	@Override
	public AvailableStampsJson getByRatings(Double lowerBound,
			Double upperBound) {
		List<Rating> ratings = ratingDAO.getRatingS(lowerBound, upperBound);
		List<Stamp> stamps = new ArrayList<Stamp>();
		for(Rating r:ratings){
			stamps.add(r.getStamp());
		}
		return StampJsonMapper.convertToAvailableStampsJson(stamps);
	}
	
	@Override
	public AvailableStampsJson getStampsByArtist(Long id) {
		return StampJsonMapper.convertToAvailableStampsJson(stampDAO.getStampsByArtist(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Offer delegator(OfferJson offerJson, boolean createPromo) throws NoSuchMethodException, SecurityException {
		@SuppressWarnings("rawtypes")
		Class c = StampBean.class;
		if(createPromo){
			if(c.getMethod("saveOffer", OfferJson.class).getAnnotation(OffersVariability.class)!=null){
				return saveOffer(offerJson);
			}else{
				return null;
			}
		}else{
			if(c.getMethod("updateOffer", OfferJson.class).getAnnotation(OffersVariability.class)!=null){
				return updateOffer(offerJson);
			}else{
				return null;
			}
		}
	}
	
	@Override
	@OffersVariability
	public Offer saveOffer(OfferJson offerJson) {
		Offer offer = stampDAO.saveOffer(StampJsonMapper.convertToOffer(offerJson));
		Stamp stamp = stampDAO.getStamp(offerJson.getStampId());
		stamp.setOffer(offer);
		stampDAO.updateStamp(stamp);
		return offer;
	}
	
	@Override
	@OffersVariability
	public Offer updateOffer(OfferJson offerJson) {
		Stamp stamp = stampDAO.getStamp(offerJson.getStampId());
		offerJson.setId(stamp.getOffer().getId());
		Offer offer = stampDAO.updateOffer(StampJsonMapper.convertToOffer(offerJson));
		return offer;
	}
	

}
