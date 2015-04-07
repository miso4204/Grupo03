package business;

import org.stamppyProject.model.business.Tshirt;

import business.DTO.ProductJsonDTO;

public interface ProductDAO {
	
	public ProductJsonDTO getAvailableTshirts();
	
	public void insertTshirt(Tshirt tshirt);
}
