package security;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.stamppyProject.model.security.User;

@Stateless
@Path("/user-service")
public class UserService {
	
	@EJB
	private UserDAO userDAO;
	
	 
//	 @GET
//		@Path("/{param}")
//		public Response printMessage(@PathParam("param") String msg) {
//	 
//			String result = "Restful example : " + msg;
//	 
//			return Response.status(200).entity(result).build();
//	 
//		}
    
     @POST
     @Path("/users/register")
     @Consumes(MediaType.APPLICATION_JSON)
     public Response registerUser(User user)
     {
    	userDAO.register(user);
        return Response.status(200).build();
     }
}
