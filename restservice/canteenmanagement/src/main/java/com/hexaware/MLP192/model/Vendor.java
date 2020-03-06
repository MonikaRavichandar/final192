
package com.hexaware.MLP192.model;
import java.util.Objects;

/**
 * Vendor class used to display vendor information.
 * @author monikaR-hexware
 */
public class Vendor {
/**
 * foodId to store venId.
   cusId to store cusId.
   venName to store venName.
   venStatus to store venStatus.
   venNo to store venNo.
   venWallet to store venWall.
 */
  private int venId;
  private String venName;
  private String venNo;
  private float venWallet;
  private String venPwd;
  /**
   * Default Constructor.
   */
  public Vendor() {

  }

  /**
  * @param argVenId to initialize venId.
  * @param argVenName to initialize venName.
  * @param argVenNo to initialize venNo.
  *@param argVenWallet to initialize venWallet.
  *@param argVenPwd to initialize venWallet.
  * used to get details through constructor.
   */
  public Vendor(final int  argVenId, final String argVenName,
       final String argVenPwd, final String argVenNo, final float argVenWallet) {
    this.venId = argVenId;
    this.venName = argVenName;
    this.venNo = argVenNo;
    this.venWallet = argVenWallet;
    this.venPwd = argVenPwd;

  }
  /**
   * @param argVenName vendor name
   * @param argVenPwd vendor pwd
   */
  public Vendor(final String argVenName, final String argVenPwd) {
    this.venName = argVenName;
    this.venPwd = argVenPwd;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.venId) || Objects.equals(venName, vendor.venName)
          || Objects.equals(venNo, vendor.venNo)
          || Objects.equals(venWallet, vendor.venWallet) || Objects.equals(venPwd, vendor.venPwd)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(venId, venName, venNo, venWallet, venPwd);
  }

    /**
     * @return this venID.
     */
  public final int getVenId() {
    return venId;
  }
  /**
     * @return this cusID.
     */

  public final String getVenPwd() {
    return venPwd;
  }
   /**
     * @return this VenName.
     */
  public final String getVenName() {
    return venName;
  }
  /**
     * @return this VenNo.
     */
  public final String getVenNo() {
    return venNo;
  }
  /**
     * @return this VenWallet.
     */
  public final float getVenWallet() {
    return venWallet;
  }
    /**
     * @param argVenId gets the  venId.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
  /**
     * @param argVenName gets the  venName.
     */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
   /**
     * @param argVenNo gets the  cusId.
     */
  public final void setVenNo(final String argVenNo) {
    this.venNo = argVenNo;
  }
    /**
     * @param argVenWallet gets the  cusId.
     */
  public final void  setVenWallet(final float argVenWallet) {
    this.venWallet = argVenWallet;
  }
  /**
     * @param argVenPwd gets the  cusId.
     */
  public final void  setVenPwd(final String argVenPwd) {
    this.venPwd = argVenPwd;
  }


}
