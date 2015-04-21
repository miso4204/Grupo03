package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.InitBean;
import org.stamppyProject.businessLogic.business.product.IProduct;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;

@Stateless
@Path("/product-service")
public class ProductService {
	
	@EJB
	private IProduct productBean;
	
	@EJB
	private InitBean initBean;
	
	@GET
	@Path("/product/{id}")
	@Produces("application/json")
	public ProductJson getProduct(@PathParam("id") Long id){
		return productBean.getProduct(id);
	}
	
	@GET
	@Path("/product/{lowerBound}/{upperBound}")
	@Produces("application/json")
	public Response getProductsByRating(@PathParam("lowerBound") Double lowerBound,
			@PathParam("upperBound") Double upperBound){
		if(initBean.getSearchRateProducts()){
			return Response.ok(productBean.getByRatings(lowerBound, upperBound)).build();
		}else{
			return Response.status(404).build();
		}
	}
	
	@POST
	@Path("/rating")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerRating(RatingJson ratingJson){
		productBean.setRating(ratingJson);
		return Response.status(200).build();
	}

}
