
package com.hexaware.MLP192.model;

import java.util.Date;
import java.util.Objects;

/**
 * Menu class used to display customer information.
 * @author hexware
 */
public class Customer {
    /**
     * cusId to store customerId.
     */
  private int cusId;
  private String cusPwd;
  private String cusName;
  private Date cusDob;
  private String cusPh;
  private String cusMailAdd;
  private float cusWallet;

/**
 * @param argCusId to initialize customer Id.
 * @param argCusPwd to initialize customer password.
 * @param  argCusName to initialize customer id.
 * @param argCusDob to initialize customer dateof birth.
 * @param argCusPh to initialize customer phone.
 * @param argCusMailAdd to initialize customer mailaddress.
 * @param argCusWallet to initialize customer wallet.
 * used to get details through constructor.
 */
  public Customer(final int argCusId, final String argCusPwd, final String argCusName, final Date argCusDob,
      final String argCusPh, final String argCusMailAdd,  final float argCusWallet) {
    this.cusId = argCusId;
    this.cusPwd = argCusPwd;
    this.cusName = argCusName;
    this.cusDob = argCusDob;
    this.cusPh = argCusPh;
    this.cusMailAdd = argCusMailAdd;
    this.cusWallet = argCusWallet;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer cus = (Customer) obj;
    if (Objects.equals(cusId, cus.cusId)
         || Objects.equals(cusPwd, cus.cusPwd)
         || Objects.equals(cusName, cus.cusName)
         || Objects.equals(cusDob, cus.cusDob)
         || Objects.equals(cusPh, cus.cusPh)
         || Objects.equals(cusMailAdd, cus.cusMailAdd)
        || Objects.equals(cusWallet, cus.cusWallet)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusPwd, cusName, cusDob, cusPh, cusMailAdd, cusWallet);
  }
    /**
     * @return this customer ID.
     */
  public final int getcusId() {
    return cusId;
  }
    /**
     * @return this customer ID.
     */

  public final String getcusPwd() {
    return cusPwd;
  }
    /**
     * @return this customer ID.
     */
  public final String getcusName() {
    return cusName;
  }
    /**
     * @return this customer ID.
     */
  public final Date getcusDob() {
    return cusDob;
  }
    /**
     * @return this customer ph.
     */
  public final String getcusPh() {
    return cusPh;
  } /**
     * @return this customer address.
     */
  public final String getcusMailAdd() {
    return cusMailAdd;
  }
     /**
     * @return this customer wallet.
     */
  public final float getcusWallet() {
    return cusWallet;
  }
    /**
     * @return this customer Add.
     */
    /**
     * @param argCusId gets the customer Id.
     */
  public final void setcusId(final int argCusId) {
    this.cusId = argCusId;
  }
    /**
     * @param argCusPwd gets the customer Id.
     */
  public final void setcusPwd(final String argCusPwd) {
    this.cusPwd = argCusPwd;
  }
    /**
     * @param argCusName gets the customer Name.
     */
  public final void setcusName(final String argCusName) {
    this.cusName = argCusName;
  }
    /**
     * @param argCusDob gets the customer Dob.
     */
  public final void setcusDob(final Date argCusDob) {
    this.cusDob = argCusDob;
  }
    /**
     * @param argCusPh gets the customer Ph.
     */
  public final void setcusPh(final String argCusPh) {
    this.cusPh = argCusPh;
  }
    /**
     * @param argCusMailAdd gets the customer Add.
     */
  public final void setcusAdd(final String argCusMailAdd) {
    this.cusMailAdd = argCusMailAdd;
  }
    /**
     * @param argCusWallet gets the customer wallet.
     */
  public final void setcusWall(final float argCusWallet) {
    this.cusWallet = argCusWallet;
  }
/**
   * Default Constructor.
   */
  public Customer() {
  }
}
