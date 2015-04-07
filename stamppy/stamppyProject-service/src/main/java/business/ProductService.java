package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stamppyProject.model.business.Tshirt;

import business.DTO.ProductJsonDTO;
import business.entityToDtoMapper.ProductJsonMapper;

@Stateless
@Path("/product-service")
public class ProductService {
	
	@EJB
	private ProductDAO productDAO;
	
	@GET
	@Path("/getProducts")
	@Produces("application/json")
	public ProductJsonDTO getAvailableProducts(){
		return productDAO.getAvailableTshirts();
	}
	
	@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response registerProduct(ProductJsonDTO productJsonDTO){
		for(Tshirt t:ProductJsonMapper.convertToTshirts(productJsonDTO)){
			productDAO.insertTshirt(t);
		}
		return Response.status(200).build();
	}

}
