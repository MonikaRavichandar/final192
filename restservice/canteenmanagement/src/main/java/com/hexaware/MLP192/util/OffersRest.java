package com.hexaware.MLP192.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP192.factory.OffersFactory;
import com.hexaware.MLP192.model.Offers;




/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/offer")
public class OffersRest {
  /**
   * Returns offer details.
   * @return the offers details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Offers[] listOffers() {
    final Offers[] offers = OffersFactory.showOffers();
    return offers;
  }
  /**
   * Returns offer details.
   * @return the offers details
   * @param newOffers for new offers
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/insertOffers")
  public final String insertOffers(final Offers newOffers) {
    String comment = "";
    final int off = OffersFactory.insertOffers(newOffers.getCusId(), newOffers.getOrdId(), newOffers.getVenId(), newOffers.getFood(),
        newOffers.getCoupCode(), newOffers.getCoupDate());
    if (off > 0) {
      comment = "{\" value \" : \" Offers added successfully \"}";
    } else {
      comment = "{\" value \" : \" Offers not added  \"}";
    }
    return comment;
  }

    /**
 * This class provides a REST interface for the employee entity.
   * Returns offer details.
   * @param cusId for cusid
   * @param off2
   * @return off2 the offers details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getOfCusId/{cusId}")
  public final Offers getOfCusId(@PathParam(" cusId ") final int cusId) {
    Offers off2 = OffersFactory.getOfCusId(cusId);
    return off2;
  }
  /**
   * This class provides a REST interface for the employee entity. Returns offer
   * details.
   * @param off1
   * @param cusId cusid
   * @return the offers details
   */

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getDate/{cusId}")
  public final Offers getDate(@PathParam(" cusId ") final int cusId) {
    Offers offer = OffersFactory.getDate(cusId);
    return offer;
  }
}
