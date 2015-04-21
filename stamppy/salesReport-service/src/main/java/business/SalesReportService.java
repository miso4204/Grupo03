package business;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.InitBean;
import org.stamppyProject.businessLogic.reports.ISalesReport;

@Stateless
@Path("/salesReport-service")
public class SalesReportService {
	
	@EJB
	private InitBean initBean;
	
	@EJB
	private ISalesReport salesReportBean;
	
	@GET
	@Path("/rating/{lowerBoud}/{upperBound}")
	@Produces("application/json")
	public Response getSalesByPeriod(@PathParam("lowerBound") Date lowerBound, @PathParam("upperBound") Date upperBound){
		try {
			return Response.ok(salesReportBean.getSalesByPeriod(lowerBound, upperBound)).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/rating/{artistId}")
	@Produces("application/json")
	public Response getStampsByRating(@PathParam("lowerBound") Long artistId){
		try {
			if(initBean.getReportRatingDesignArtist())
				return Response.ok(salesReportBean.getSalesByArtist(artistId)).build();
			else
				return Response.status(404).build(); 
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

}
