package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.business.socialNetwork.ISocialNetwork;

@Stateless
@Path("/socialNetwork-service")
public class SocialNetworkService {
	
	@EJB
	private ISocialNetwork socialNetworBean;
	
	@GET
	@Path("/twitter")
	@Produces("application/json")
	public Response getTwiter(){
		return Response.ok(socialNetworBean.twitterPost()).build();
	}
	
	@GET
	@Path("/facebook")
	@Produces("application/json")
	public Response getFacebook(){
		return Response.ok(socialNetworBean.facebookPost()).build();
	}

}
