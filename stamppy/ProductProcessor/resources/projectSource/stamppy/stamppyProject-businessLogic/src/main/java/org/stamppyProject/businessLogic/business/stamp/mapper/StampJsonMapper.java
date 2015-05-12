package org.stamppyProject.businessLogic.business.stamp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.OfferJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;
import org.stamppyProject.model.business.Offer;
import org.stamppyProject.model.business.Stamp;

public class StampJsonMapper {
	
	public static Stamp convertToStamp(StampJson stampJson){	
		Stamp stamp = new Stamp();
		stamp.setId(stampJson.getId());
		stamp.setName(stampJson.getName());
		stamp.setPrice(stampJson.getPrice());
		stamp.setUrl(stampJson.getUrl());
		stamp.setKeyWords(stampJson.getKeyWords());
		return stamp;
	}
	
	public static StampJson convertToStampJson(Stamp stamp){
		StampJson stampJson = new StampJson();
		stampJson.setId(stamp.getId());
		stampJson.setArtistId(stamp.getSeller().getId());
		stampJson.setName(stamp.getName());
		stampJson.setPrice(stamp.getPrice());
		stampJson.setUrl(stamp.getUrl());
		stampJson.setKeyWords(stamp.getKeyWords());
		stampJson.setArtistName(stamp.getSeller().getUsername());
		if(stamp.getRating()!=null)
			stampJson.setRating(RatingJsonMapper.convertToRatingJson(stamp.getRating()));
		if(stamp.getOffer()!=null && stamp.getOffer().getDiscount()>0)
			stampJson.setOfferPrice(stamp.getPrice()-(stamp.getPrice()*stamp.getOffer().getDiscount()/100));
		return stampJson;
	}
	
	public static AvailableStampsJson convertToAvailableStampsJson(List<Stamp> stamps){
		AvailableStampsJson available = new AvailableStampsJson();
		available.setNumberStamps(stamps.size());
		List<StampJson> stampJsons = new ArrayList<StampJson>();
		for(Stamp stamp : stamps){
			if(stamp!=null){
				stampJsons.add(convertToStampJson(stamp));
			}	
		}
		available.setStamps(stampJsons);
		return available;
	}
	
	public static Offer convertToOffer(OfferJson offerJson){
		Offer offer = new Offer();
		offer.setId(offerJson.getId());
		offer.setDiscount(offerJson.getDiscount());
		return offer;
	}

}
