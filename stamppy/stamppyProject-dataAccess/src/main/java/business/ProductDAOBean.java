package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Tshirt;

import EntityToDtoMapper.TotalProductJsonMapper;
import business.DTO.TotalProductJsonDTO;

@Stateless
public class ProductDAOBean implements ProductDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public TotalProductJsonDTO getAvailableTshirts() {	
		List<Tshirt> tshirts = em.createNamedQuery("tshirt.findAllAvailable")
				.getResultList();
		for(Tshirt t:tshirts){
			t.setAvailableColors(em.createNamedQuery("availableColors.findByTshirt")
					.setParameter("tshirt", t)
					.getResultList());
			t.setAvailableSizes(em.createNamedQuery("availableSizes.findByTshirt")
					.setParameter("tshirt", t)
					.getResultList());
		}
		TotalProductJsonDTO result = TotalProductJsonMapper.convert(tshirts);
		return result;
	}

}
