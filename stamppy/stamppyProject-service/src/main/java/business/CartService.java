package business;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.stamppyProject.businessLogic.business.cart.ICart;
import org.stamppyProject.businessLogic.business.cart.dto.CartJson;
import org.stamppyProject.businessLogic.business.cart.dto.PaymentJson;
import org.stamppyProject.businessLogic.business.product.IProduct;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;

@Stateless
@Path("/cart-service")
public class CartService {
	
	@EJB
	private ICart cartBean;
	
	@EJB
	private IProduct productBean;
	
	@POST
	@Path("/cart")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertProduct(ProductJson productJson){
		productBean.insertProduct(productJson);
		return Response.status(200).build();
	}
	
	@GET
	@Path("/cart/{userId}")
	@Produces("application/json")
	public CartJson getCart(@PathParam("userId") Long userId){
		return cartBean.getTempCart(userId);
	}
	
	@DELETE
	@Path("/cart/{cartId}/{productId}")
	public Response removeStamp(@PathParam("cartId") Long cartId, @PathParam("productId") Long productId){
		cartBean.removeItem(cartId, productId);
		return Response.status(200).build();
	}
	
	@POST
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response purchase(PaymentJson paymentJson){
		try {
			return Response.ok(cartBean.purchaseProducts(paymentJson)).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}
}
