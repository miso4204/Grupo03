package org.stamppyProject.dataAccess.business.rating;

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
	public Rating getRating(Long id) {
		try {
			return (Rating)em.createNamedQuery("Rating.findByStamp")
					.setParameter("stampId", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
}
