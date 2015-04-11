package security;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.security.IUser;
import org.stamppyProject.businessLogic.security.dto.UserJson;


@Stateless
@Path("/user-service")
public class UserService {
	
	@EJB
	private IUser userBean;
	
    
     @POST
     @Path("/register")
     @Consumes(MediaType.APPLICATION_JSON)
     public Response registerUser(UserJson userJson)
     {
    	userBean.registerUser(userJson);;
        return Response.status(200).build();
     }
     
}
