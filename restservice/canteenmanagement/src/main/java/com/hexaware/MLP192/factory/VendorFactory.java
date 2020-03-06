package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.VendorDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP192.model.Vendor;
/**
 * VendorFactory class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().showVend();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
   /**
   * Call the data base connection.
   * @param venName insert VENNAME.
   * @param venPwd insert VenPwd.
   * @param venNo insert VenPh.
   * @return the array of Vendor object.
   */
  public static int signupVendor(final String venName, final String venPwd, final String venNo) {
    int i = dao().signingVendor(venName, venPwd, venNo);
    return i;
  }
  /**
   * Call the data base connection.
   * @param venName insert VENNAME.
   * @param venPwd insert VenPwd.
   * @return the array of Vendor object.
   */
  public static Vendor loginVendor(final String venName, final String venPwd) {
    Vendor vendor = dao().loginingVendor(venName, venPwd);
    return vendor;
  }
  /**
   * @param venWallet wallet
   * @param venId id
   * @return the array of customer object.
   */
  public static int  updateVendorWalBal(final int venId, final float venWallet) {
    int vendor = dao().updatingVendorWal(venId, venWallet);
    return vendor;
  }
   /**
  * @param name id
  * @return  customer  bal.
  */
  public static Vendor showVenWalletBalance(final int name) {
    Vendor vendor = dao().showvenWalBal(name);
    return vendor;
  }
}

