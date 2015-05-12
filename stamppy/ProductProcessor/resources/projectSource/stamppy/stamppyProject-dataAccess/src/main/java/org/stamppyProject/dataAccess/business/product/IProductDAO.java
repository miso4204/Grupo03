package org.stamppyProject.dataAccess.business.product;

import java.util.Date;
import java.util.List;

import org.stamppyProject.model.business.Product;

public interface IProductDAO {
	
	public void saveProduct(Product product);
	
	public Product saveProductAdmin(Product product);
	
	public void updateProduct(Product product);
	
	public Product getProduct(Long id);
	
	public List<Product> getSalesByPeriod(Date lowerBound, Date upperBound);
	
	public List<Product> getSalesByArtist(Long artistId);
	
	public List<Product> getAllProducts();

}
