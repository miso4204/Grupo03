package org.stamppyProject.businessLogic.business.stamp;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;
import org.stamppyProject.businessLogic.business.stamp.mapper.StampJsonMapper;
import org.stamppyProject.dataAccess.business.rating.IRatingDAO;
import org.stamppyProject.dataAccess.business.stamp.IStampDAO;
import org.stamppyProject.dataAccess.security.IUserDAO;
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
		Rating rating = ratingDAO.getRating(ratingJson.getStampId());
		if(rating!=null){
			rating.setRatings(rating.getRatings()+1);
			rating.setAverageRating((rating.getAverageRating()+ratingJson.getCalification())/rating.getRatings());
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

}
