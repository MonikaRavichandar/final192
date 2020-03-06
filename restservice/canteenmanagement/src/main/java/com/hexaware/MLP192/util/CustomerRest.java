
package com.hexaware.MLP192.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP192.model.Customer;
import com.hexaware.MLP192.factory.CustomerFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listCustomer() {
    final Customer[] customer = CustomerFactory.showCustomer();
    return customer;
  }
  /**
   * @return dhf
   * @param newCustomer gsd

   */
  @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/addcustomer")
  public final String addingCustomer(final Customer newCustomer) {
    String comment = "";
    final int carIns = CustomerFactory.insertCustomer(newCustomer.getcusName(), newCustomer.getcusPwd(), newCustomer.getcusDob(),
        newCustomer.getcusPh(), newCustomer.getcusMailAdd(), newCustomer.getcusWallet());
    if (carIns > 0) {
      comment = "{\" value \" : \" Customer added successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not added  \"}";
    }
    return comment;
  }
   /**
   * Returns Customer details.
   * @param cusName customer name.
   * @param cusPwd customer password.
   * @return the customer details
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/check/{cusName}/{cusPwd}")
    public final Customer logincus(@PathParam("cusName")final String cusName, @PathParam("cusPwd")final String cusPwd) {
    final Customer cus = CustomerFactory.loginCustomer(cusName, cusPwd);
    return cus;
  }
   /**
   * Returns Customer details.
   * @return the Customer details
   * @param newCustomer gsd
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateCustomer")
  public final String updateCustomer(final Customer newCustomer) {
    String comment = "";
    final int customerIns = CustomerFactory.updateCustomer(newCustomer.getcusPh(), newCustomer.getcusId());
    if (customerIns > 0) {
      comment = "{\" value \" : \" Customer updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not updated  \"}";
    }

    return comment;
  }
  /**
   * Returns Customer details.
   * @return the Customer details
   * @param cusName gsd

   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/viewcustomer/{cusName}")
  public final Customer viewCustomer(@PathParam("cusName")final String cusName) {
    final Customer customerIns = CustomerFactory.viewCustomer(cusName);
    return customerIns;
  }
  /**
   * Returns Customer details.
   * @return the Customer details
   * @param cusId gsd

   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/customerbalanceid/{cusid}")
  public final Customer customerBalance(@PathParam("cusid")final int cusId) {
    final Customer customerIns = CustomerFactory.showCusWalletBalance(cusId);
    return customerIns;
  }
  /**
   * Returns Customer details.
   * @return the Customer details
   * @param newCustomer gsd

   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatecustomerwalbal")
  public final String updateCustomerW(final Customer newCustomer) {
    String comment = "";
    final int customerIns = CustomerFactory.updateCustomerWalBal(newCustomer.getcusId(), newCustomer.getcusWallet());
    if (customerIns > 0) {
      comment = "{\" value \" : \" Customer updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not updated  \"}";
    }
    return comment;
  }
}
