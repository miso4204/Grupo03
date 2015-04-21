package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.InitBean;
import org.stamppyProject.businessLogic.business.stamp.IStamp;
import org.stamppyProject.businessLogic.business.stamp.dto.AvailableStampsJson;
import org.stamppyProject.businessLogic.business.stamp.dto.RatingJson;
import org.stamppyProject.businessLogic.business.stamp.dto.StampJson;

@Stateless
@Path("/stamp-service")
public class StampService {
	
	@EJB
	private IStamp stampBean;
	
	@EJB
	private InitBean initBean;
	
	@POST
	@Path("/stamp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerStamp(StampJson stampJson){
		stampBean.saveStamp(stampJson);
		return Response.status(200).build();
	}
	
	@PUT
	@Path("/stamp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStamp(StampJson stampJson){
		stampBean.updateStamp(stampJson);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/stamp")
	@Produces("application/json")
	public AvailableStampsJson getAvailableStamps(){
		return stampBean.getAvailableStamps();
	}
	
	@GET
	@Path("/stamp/{id}")
	@Produces("application/json")
	public StampJson getStamp(@PathParam("id") Long id){
		return stampBean.getStamp(id);
	}
	
	@DELETE
	@Path("/stamp/{id}")
	public Response removeStamp(@PathParam("id") Long id){
		stampBean.setStampNotAvailable(id);
		return Response.status(200).build();
	}
	
	@POST
	@Path("/rating")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerRating(RatingJson ratingJson){
		stampBean.setRating(ratingJson);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/stamp/{lowerBound}/{upperBound}")
	@Produces("application/json")
	public Response getStampsByRating(@PathParam("lowerBound") Double lowerBound,
			@PathParam("upperBound") Double upperBound){
		if(initBean.getSearchRateDesigns()){
			return Response.ok(stampBean.getByRatings(lowerBound, upperBound)).build();
		}else{
			return Response.status(404).build();
		}
	}
	
	

}
