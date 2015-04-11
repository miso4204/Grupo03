package org.stamppyProject.dataAccess.business.product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Product;

@Stateless
public class ProductDAO implements IProductDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void saveProduct(Product product) {
		em.persist(product);
	}

}
