package security;

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

import org.stamppyProject.businessLogic.security.IUser;
import org.stamppyProject.businessLogic.security.dto.UserJson;

import business.StampJson;


@Stateless
@Path("/user-service")
public class UserService {
	
	@EJB
	private IUser userBean;
	
    
     @POST
     @Path("/register")
     @Consumes(MediaType.APPLICATION_JSON)
     public Response registerUser(UserJson userJson){
    	userBean.registerUser(userJson);
        return Response.status(200).build();
     }
     
 	@PUT
 	@Path("/user")
 	@Consumes(MediaType.APPLICATION_JSON)
 	public Response updateUser(UserJson userJson){
 		userBean.updateUser(userJson); 		
 		return Response.status(200).build();
 	}
 	
 	@GET
	@Path("/user/{id}")
	@Produces("application/json")
	public UserJson getStamp(@PathParam("id") Long id){
		return userBean.getSUser(id);
	}
 	
 	@DELETE
	@Path("/user/{id}")
	public Response removeUser(@PathParam("id") Long id){
 		return Response.status(200).build();
 	}
     
}
