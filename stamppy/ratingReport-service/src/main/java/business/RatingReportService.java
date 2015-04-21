package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.InitBean;
import org.stamppyProject.businessLogic.reports.IRatingReport;

@Stateless
@Path("/ratingReport-service")
public class RatingReportService {
	
	@EJB
	private InitBean initBean;
	
	@EJB
	private IRatingReport ratingReportBean;
	
	@GET
	@Path("/rating")
	@Produces("application/json")
	public Response getStampsByRating(){
		try {
			return Response.ok(ratingReportBean.getAllRatingStamps()).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/rating/{artistId}")
	@Produces("application/json")
	public Response getStampsByRatingAndArtist(@PathParam("lowerBound") Long artistId){
		try {
			if(initBean.getReportRatingDesignArtist())
				return Response.ok(ratingReportBean.getAllRatingStampsByArtist(artistId)).build();
			else
				return Response.status(404).build(); 
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

}
