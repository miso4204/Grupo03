package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import business.DTO.TotalProductJsonDTO;

@Stateless
@Path("/product-service")
public class ProductService {
	
	@EJB
	private ProductDAO productDAO;
	
	@GET
	@Path("/getProducts")
	@Produces("application/json")
	public TotalProductJsonDTO getAvailableProducts(){
		return productDAO.getAvailableTshirts();
	}

}
