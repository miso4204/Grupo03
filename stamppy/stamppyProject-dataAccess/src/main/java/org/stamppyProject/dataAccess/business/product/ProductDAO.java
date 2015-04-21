package org.stamppyProject.dataAccess.business.product;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Product;
import org.stamppyProject.model.enumerations.CartStatusEnum;

@Stateless
public class ProductDAO implements IProductDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void saveProduct(Product product) {
		em.persist(product);
	}
	
	@Override
	public void updateProduct(Product product) {
		em.merge(product);
	}
	
	@Override
	public Product getProduct(Long id) {
		return em.find(Product.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getSalesByArtist(Long artistId) {
		return em.createNamedQuery("Product.findAllSalesByArtistAndCartStatus")
				.setParameter("cartStatus", CartStatusEnum.CHECKOUT)
				.setParameter("artistId", artistId)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getSalesByPeriod(Date lowerBound, Date upperBound) {
		return em.createNamedQuery("Product.findAllSalesByPeriodAndCartStatus")
				.setParameter("cartStatus", CartStatusEnum.CHECKOUT)
				.setParameter("lowerBound", lowerBound)
				.setParameter("upperBound", upperBound)
				.getResultList();
	}

}
