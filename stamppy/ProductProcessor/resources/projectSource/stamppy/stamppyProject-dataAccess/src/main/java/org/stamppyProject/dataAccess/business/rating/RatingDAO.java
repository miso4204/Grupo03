package org.stamppyProject.dataAccess.business.rating;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Rating;

@Stateless
public class RatingDAO implements IRatingDAO{
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void saveRating(Rating rating) {
		em.persist(rating);
		
	}
	
	@Override
	public void updateRating(Rating rating) {
		em.merge(rating);
	}
	
	@Override
	public Rating getRatingByStamp(Long id) {
		try {
			return (Rating)em.createNamedQuery("Rating.findByStamp")
					.setParameter("stampId", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	@Override
	public Rating getRatingByProduct(Long id) {
		try {
			return (Rating)em.createNamedQuery("Rating.findByProduct")
					.setParameter("productId", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getRatingP(Double lowerBound, Double upperBound) {
		return em.createNamedQuery("Rating.findProductsByBoundaries")
				.setParameter("lowerBound", lowerBound)
				.setParameter("upperBound", upperBound)
				.getResultList();
				
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getRatingS(Double lowerBound, Double upperBound) {
		return em.createNamedQuery("Rating.findStampByBoundaries")
				.setParameter("lowerBound", lowerBound)
				.setParameter("upperBound", upperBound)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getAllRatingStamps() {
		return em.createNamedQuery("Rating.findAllStamps")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getAllRatingStampsByArtist(Long artistId) {
		return em.createNamedQuery("Rating.findAllStampsByArtist")
				.setParameter("artistId", artistId)
				.getResultList();
	}
	
	
	
}
