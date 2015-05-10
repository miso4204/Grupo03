package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.business.stamp.IStamp;
import org.stamppyProject.businessLogic.business.stamp.dto.OfferJson;
import org.stamppyProject.model.business.Offer;

@Stateless
@Path("/offers-service")
public class OfferService {
	
	@EJB
	private IStamp stampBean;
	
	@POST
	@Path("/offer")
	@Consumes("application/json")
	@Produces("application/json")
	public Response setOffer(OfferJson offerJson){
		try {
			Offer offer = stampBean.saveOffer(offerJson);
			if(offer!=null){
				return Response.ok(offer).build();
			}else{
				return Response.status(404).build();
			}
			
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("/offer")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateOffer(OfferJson offerJson){
		try {
			Offer offer = stampBean.updateOffer(offerJson);
			if(offer!=null){
				return Response.ok(offer).build();
			}else{
				return Response.status(404).build();
			}
			
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	

}
