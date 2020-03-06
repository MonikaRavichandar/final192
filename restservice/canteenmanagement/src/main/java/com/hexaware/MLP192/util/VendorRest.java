package com.hexaware.MLP192.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP192.model.Vendor;
import com.hexaware.MLP192.factory.VendorFactory;

/**
 * This class provides a REST interface for the vendor entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Vendor details.
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }
   /**
   * Returns Vendor details.
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/balance")
  public final Vendor showwalletbalance() {
    final Vendor vendor = VendorFactory.showVenWalletBalance(40);
    return vendor;
  }
   /**
   * Returns Vendor details.
   * @return the Vendor details
   * @param newVendor vendor.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateVendorWalBal")
  public final String  updateVendorWalBal(final Vendor newVendor) {
    String comment = "";
    final int vendorUpdate = VendorFactory.updateVendorWalBal(newVendor.getVenId(), newVendor.getVenWallet());
    if (vendorUpdate > 0) {
      comment = "{\" value \" : \" Vendor updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not updated  \"}";
    }

    return comment;

  }
  /**
   * Returns Vendor details.
   * @return the Vendor details
   * @param venId vendor.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showVendor/{id}")
  public final Vendor showVendorWalBal(@PathParam("id") final int venId) {
    final Vendor vendor = VendorFactory.showVenWalletBalance(venId);
    return vendor;
  }
  /**
   * Returns Vendor details.
   * @return the Vendor details
   * @param newVendor vendor.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addvendor")
  public final String insertVendor(final Vendor newVendor) {
    String comment = "";
    final int venIns = VendorFactory.signupVendor(newVendor.getVenName(), newVendor.getVenPwd(), newVendor.getVenNo());
    if (venIns > 0) {
      comment = "{\" value \" : \" Vendor added successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not added  \"}";
    }

    return comment;

  }
   /**
   * Returns Vendor details.
   * @return the Vendor details
   * @param venName vendor.
   * @param venPwd vendor.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/loginVendor/{name}/{pwd}")
  public final Vendor loginVendor(@PathParam("name")final String venName, @PathParam("pwd")final String venPwd) {
    final Vendor vendor = VendorFactory.loginVendor(venName, venPwd);
    return vendor;
  }
}


