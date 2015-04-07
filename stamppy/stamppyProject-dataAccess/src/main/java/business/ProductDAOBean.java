package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Tshirt;

import business.DTO.ProductJsonDTO;
import business.entityToDtoMapper.ProductJsonMapper;

@Stateless
public class ProductDAOBean implements ProductDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public ProductJsonDTO getAvailableTshirts() {	
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
		ProductJsonDTO result = ProductJsonMapper.convertToProductJsonDTO(tshirts);
		return result;
	}
	
	@Override
	public void insertTshirt(Tshirt tshirt) {
		em.persist(tshirt);
		
	}

}
