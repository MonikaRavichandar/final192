
package com.hexaware.MLP192.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP192.factory.OrdersFactory;
import com.hexaware.MLP192.model.Orders;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/order")
public class OrdersRest {
  /**
   * Returns vendor details.
   * @return the vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] listOrder() {
    final Orders[] orders = OrdersFactory.showOrders();
    return orders;
  }
     /**
   * inserts Orders details.
   * @param newOrder new Order.
   * @return the order details
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addOrder")
  public final String addOrder(final Orders newOrder) {
    String comment = "";

    final int orderInsert = OrdersFactory.insertingorders(newOrder.getcusId(),
        newOrder.getordItemSel(), newOrder.getordDate(), newOrder.getordQty(), newOrder.getordStatus(), newOrder.getordCost(), newOrder.getVenId());
    if (orderInsert > 0) {
      comment = "{\" value \" : \" order added successfully \"}";
    } else {
      comment = "{\" value \" : \" order not added  \"}";
    }
    return comment;
  }
       /**
   * updates Order details.
   * @param cusId new order.
   *  @param ordStatus new order.
   * @return the Order details
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateOrderStatus/{cusId}/{ordStatus}")
  public final String updateOrderStatus(@PathParam("cusId")final int cusId, @PathParam("ordStatus")final String ordStatus) {
    String comment = "";
    final int menuUpdate = OrdersFactory.updateOrdStatus(cusId, ordStatus);
    if (menuUpdate > 0) {
      comment = "{\" value \" : \" orders updated successfully \"}";
    } else {
      comment = "{\" value \" : \" orders not updated  \"}";
    }
    return comment;
  }
    /**
   * show Order details.
   * @param tokenId new order.
   * @return the Order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showOrder/{id}")
  public final Orders showOrders(@PathParam("tokenId")final int tokenId) {
    final Orders orders = OrdersFactory.getOrderDetails(tokenId);
    return orders;
  }
/**
   * show Order details.
   * @param cusId new order.
   * @return the Order details
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showCustomer/{id}")
  public final Orders[] showCustomer(@PathParam("cusId")final int cusId) {
    final Orders[] orders = OrdersFactory.showCusOrders(cusId);
    return orders;
  }
    /**
   * updates order details.
   * @param newOrder new order.
   * @return the Order details
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateOrder")
  public final String updateOrder(final Orders newOrder) {
    String comment = "";
    final int orderUpdate = OrdersFactory.updatingORDERS(newOrder.getordItemSel(), newOrder.gettokenId());
    if (orderUpdate > 0) {
      comment = "{\" value \" : \" menu updated successfully \"}";
    } else {
      comment = "{\" value \" : \" menu not updated  \"}";
    }
    return comment;
  }
   /**
   * Returns order details.
   * @param tokenId ord id.
   * @return the order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/checkOrders/{tokenId}")
  public final Orders checkOrders(@PathParam("tokenId")final int tokenId) {
    final Orders menu = OrdersFactory.validateOrder(tokenId);
    return menu;
  }
   /**
   * Returns order details.
   * @return the order detail
   * @param cusId token parameter.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showOrders1/{cid}")
  public final Orders showcusOrders(@PathParam("cid") final int cusId) {
    final Orders newOrders = OrdersFactory.getOrder(cusId);
    return newOrders;
  }
    /**
   * updates Order details.
   * @param tokenId new order.
   *  @param ordStatus new order.
   * @return the Order details
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/cancelOrderStatus/{tokenId}/{ordStatus}")
  public final String cancelOrder(@PathParam("tokenId")final int tokenId, @PathParam("ordStatus")final String ordStatus) {
    String comment = "";
    final int menuUpdate = OrdersFactory.cancelOrder(tokenId, ordStatus);
    if (menuUpdate > 0) {
      comment = "{\" value \" : \" orders updated successfully \"}";
    } else {
      comment = "{\" value \" : \" orders not updated  \"}";
    }
    return comment;
  }
}
