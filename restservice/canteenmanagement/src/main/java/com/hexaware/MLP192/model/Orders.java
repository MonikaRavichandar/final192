
package com.hexaware.MLP192.model;

import java.util.Date;

/**
 * Orders class used to display orders information.
 * @author priyadharshini-hexware
 */
public class Orders {
/**
 * cusId to store cusid.
 */
  private int  cusId;
  private int  tokenId;
  private Date ordDate;
  private String ordItemSel;
  private int ordQty;
  private String ordStatus;
  private float ordCost;
  private int venId;
/**
 *@param argCusId to initialize customer id.
 *@param argTokenId to initialize order id
 *@param argOrdDate to initialize order date
 *@param argOrdItemSel to initialize order item sel
 *@param argOrdQty to initialize order quantity
 *@param argOrdStatus to initialize order quantity
 *@param argOrdCost to initialize order cost
 *@param argVenId to initialize order cost
 * used to get details through constructor.
 */
  public Orders(final int argCusId, final int argTokenId, final Date argOrdDate,
      final String argOrdItemSel, final int argOrdQty, final String argOrdStatus, final float argOrdCost, final int argVenId) {
    this.cusId = argCusId;
    this.tokenId = argTokenId;
    this.ordDate = argOrdDate;
    this.ordItemSel = argOrdItemSel;
    this.ordQty = argOrdQty;
    this.ordStatus = argOrdStatus;
    this.ordCost = argOrdCost;
    this.venId = argVenId;
  }
  /**
   * Default Constructor.
   * @param tid for integer
   */
  public Orders(final int tid) {
    this.tokenId = tid;
  }
  /**
   * Default Constructor.
   */
  public Orders() {
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Orders orders = (Orders) obj;
    if (java.util.Objects.equals(cusId, orders.cusId) || java.util.Objects.equals(tokenId, orders.tokenId)
         || java.util.Objects.equals(ordDate, orders.ordDate)
         || java.util.Objects.equals(ordItemSel, orders.ordItemSel)
         ||  java.util.Objects.equals(ordQty, orders.ordQty)
         || java.util.Objects.equals(ordStatus, orders.ordStatus)
         || java.util.Objects.equals(venId, orders.venId)) {
      return true;
    }
    return false;
  }
  @Override
public final int hashCode() {
    return java.util.Objects.hash(cusId, tokenId, ordDate, ordItemSel, ordQty, ordStatus, ordCost, venId);
  }

/**
 * @return this cusId,ordId,ordDate,ordTime,ordItemSel.
 */
  public final int getcusId() {
    return cusId;
  }
/**
 * @return this ordID.
 */

  public final int gettokenId() {
    return tokenId;
  }
/**
 * @return this ordDate.
 */
  public final Date getordDate() {
    return ordDate;
  }
/**
 * @return this ordItemSel.
 */

  public final String getordItemSel() {
    return ordItemSel;
  }
  /**
 * @return this ordItemSel.
 */

  public final String getordStatus() {
    return ordStatus;
  }
  /**
 * @return this ord qty.
 */

  public final int  getordQty() {
    return ordQty;
  }
   /**
 * @return this ordItemSel.
 */
  public final float getordCost() {
    return ordCost;
  }
  /**
 * @return this ordItemSel.
 */
  public final int getVenId() {
    return venId;
  }
/**
     * @param argCusId gets the customer id.
     */

  public final void setCusId(final int argCusId) {
    this.cusId =  argCusId;
  }
/**
     * @param argTokenId gets the order id.
     */
  public final void setTokenId(final int  argTokenId) {

    this.tokenId = argTokenId;
  }
/**
     *@param argOrdDate gets the order date.
     */
  public final void setOrdDate(final Date argOrdDate) {
    this.ordDate = argOrdDate;
  }
/**
     * @param argOrdItemSel gets the order Item Sel.
     */
  public final void setOrdItemSel(final String argOrdItemSel) {
    this.ordItemSel = argOrdItemSel;
  }
  /**
     * @param argOrdQty gets the order Item Sel.
     */
  public final void setOrdQty(final int argOrdQty) {
    this.ordQty = argOrdQty;
  }
  /**
     * @param argOrdStatus gets the order Item Sel.
     */
  public final void setOrdStatus(final String argOrdStatus) {
    this.ordStatus = argOrdStatus;
  }
   /**
     * @param argOrdCost gets the order Item Sel.
     */
  public final void setOrdCost(final float argOrdCost) {
    this.ordCost = argOrdCost;
  }
  /**
     * @param argVenId gets the order Item Sel.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
}


