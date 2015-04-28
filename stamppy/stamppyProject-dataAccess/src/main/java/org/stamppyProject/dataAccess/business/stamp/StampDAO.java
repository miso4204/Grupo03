
package org.stamppyProject.dataAccess.business.stamp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Stamp;
import org.stamppyProject.model.enumerations.StampStatusEnum;

@Stateless
public class StampDAO implements IStampDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Stamp> getAvailableStamps() {	
		return em.createNamedQuery("Stamp.findByStatus")
				.setParameter("status", StampStatusEnum.AVAILABLE)
				.getResultList();
	}
	
	@Override
	public void insertStamp(Stamp stamp) {
		em.persist(stamp);
	}
	
	@Override
	public void deleteStamp(Stamp stamp) {
		em.remove(stamp);
	}
	
	@Override
	public void updateStamp(Stamp stamp) {
		em.merge(stamp);
	}
	
	@Override
	public Stamp getStamp(Long id) {
		return em.find(Stamp.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Stamp> getStampsByArtist(Long id) {
		return em.createNamedQuery("Stamp.findByArtist")
				.setParameter("artistId", id)
				.getResultList();
	}

}
