
package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.OrdersDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.Date;
import java.util.List;

import com.hexaware.MLP192.model.Orders;

/**
 * OrdersFactory class used to fetch menu data from database.
 * @author priyadharshini
 */
public class OrdersFactory {
  /**
   * Protected constructor.
   */
  protected OrdersFactory() {

  }

  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().showOrder();
    return orders.toArray(new Orders[orders.size()]);
  }

  /**
   *
   * @param cusId customer id
   * @param ordItemSel items selected
   * @param ordQty order quantity
   * @param ordDate order Date
   * @param ordStatus order status
   * @param ordCost order cost
   * @param venId order cost
   * @return int
   */
  public static int insertingorders(final int cusId, final String ordItemSel, final Date ordDate,
       final int ordQty, final String ordStatus, final float ordCost, final int venId) {
    java.sql.Date scbod = null;
    scbod = new java.sql.Date(ordDate.getTime());
    int i = dao().insertorders(cusId, ordItemSel, ordQty, scbod, ordStatus, ordCost, venId);
    return i;
  }
     /**
   * @param tokenId customer id
   * @param ordItemSel items selected
   * @return NN
   */
  public static int updatingORDERS(final String ordItemSel, final int  tokenId) {
    int j = dao().updateORDERS(ordItemSel, tokenId);
    return j;
  }
   /**
   * @param ordStatus ordStatus
   * @param cusId id
   * @return the array of customer object.
   */
  public static int updateOrdStatus(final int cusId, final String ordStatus) {
    int order = dao().updateOrStatus(cusId, ordStatus);
    return order;
  }
   /**
   * Call the data base connection.
   * @param tokenId for order id.
   * @return Orders
   */
  public static Orders validateOrder(final int tokenId) {
    Orders v = dao().validateOrders(tokenId);
    return v;
  }
   /**
   * Call the data base connection.
   * @param tokenId for order id.
   * @return Orders
   */
  public static Orders getOrderDetails(final int tokenId) {
    Orders od = dao().getOrderDetails(tokenId);
    return od;
  }
  /**
  * @param cusId id
  * @return  customer  bal.
  */
  public static Orders[] showCusOrders(final int cusId) {
    List<Orders> orders = dao().showCOrders(cusId);
    return orders.toArray(new Orders[orders.size()]);
  }
   /**
   * Call the data base connection.
   * @param cusId for order id.
   * @return Orders
   */
  public static Orders getTokenId(final int cusId) {
    Orders od = dao().getOrderId(cusId);
    return od;
  }
  /**
     * @return message.
     * @param cusId gets ordertoken.
     * */
  public static Orders getOrder(final int cusId) {
    Orders ord = dao().showOrder(cusId);
    return ord;
  }
  /**
   * @param ordStatus ordStatus
   * @param tokenId id
   * @return the array of customer object.
   */
  public static int cancelOrder(final int tokenId, final String ordStatus) {
    int order = dao().cancelOrder(tokenId, ordStatus);
    return order;
  }
}
