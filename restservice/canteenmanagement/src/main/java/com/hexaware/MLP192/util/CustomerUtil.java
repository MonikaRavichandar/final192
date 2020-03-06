
package com.hexaware.MLP192.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.hexaware.MLP192.factory.CustomerFactory;
//import com.hexaware.MLP192.factory.OrdersFactory;
import com.hexaware.MLP192.model.Customer;
//import com.hexaware.MLP192.model.Orders;

/**
 * CustomerUtil.java used as Client interface for java coding.
 * @Monika-hexware
 */
class CustomerUtil {
  private static Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * CustomerUtil.java used as Client interface for java coding.
   * @Monika-hexware
   */
  protected CustomerUtil() {

  }

  /**
   * CustomerUtil.java used as Client interface for java coding.
   * @throws ParseException is thrown
   * @Monika-hexware
   */
  public void customerMain() throws ParseException {
    System.out.println("CUSTOMER");
    System.out.println("1.Sign Up");
    System.out.println("2.Log In");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      default:
        customerMain();
        break;
      case 1:
        System.out.println("Enter the cusName");
        final String cusName = option.next();
        System.out.println("Enter the password");
        final String cusPwd = option.next();
        System.out.println("Enter the date of birth");
        final String cusDob = option.next();
        System.out.println("Enter the phone number");
        final String cusPh = option.next();
        System.out.println("Enter the Address");
        final String cusAdd = option.next();
        System.out.println("Enter the Wallet details");
        final float cusWallet = option.nextFloat();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date pDate = sdf.parse(cusDob);
        CustomerFactory.insertCustomer(cusPwd, cusName, pDate, cusPh, cusAdd, cusWallet);
        break;
      case 2:
        System.out.println("Enter the cusName");
        final String name = option.next();
        System.out.println("Enter the password");
        final String password = option.next();
        final Customer c = CustomerFactory.loginCustomer(name, password);
    /**
  * CliMain used as Client interface for java coding.
  * @Magudi-hexware
   */
        final OrdersUtil odUtil = new OrdersUtil();
        try {
          if (c.getcusName().equals(name) && c.getcusPwd().equals(password)) {
            System.out.println("----------------------------");
            System.out.println("WELCOME  " + name.toUpperCase());
            System.out.println("----------------------------");
            System.out.println("1.PLACE ORDER");
            System.out.println("2.DISPLAY ORDER HISTORY");
            System.out.println("3.CUSTOMER WALLET");
            System.out.println("4.VIEW AND EDIT PERSONAL DETAILS");
            System.out.println("5.FOR EXIT");
            final int menu = option.nextInt();
            switch (menu) {
              case 1:
                odUtil.showPlaceOrder();
                break;
              case 2:
                displayOrderHistory();
                break;
              case 3:
                showCustWallet();
                break;
              case 4:
                showCustomer();
                break;
              case 5:
                Runtime.getRuntime().halt(0);
              default:
                showFullCustomer();
                break;
            }
          }
        } catch (final Exception e) {
          e.printStackTrace();
          System.out.println("Enter a valid data");
        }
    }
  }

  private void showCustomer() {
    int cusId;
    String cusPh;
    System.out.println("-------------------");
    System.out.println("1.View Profile");
    System.out.println("2.Edit profile");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 2:
        System.out.println("Enter the customer phone");
        cusPh = option.next();
        System.out.println("Enter the customer Id");
        cusId = option.nextInt();
        final int j = CustomerFactory.updateCustomer(cusPh, cusId);
        if (j > 0) {
          System.out.println("updated succesfully");
        } else {
          System.out.println("not updated");
        }
        break;
      case 1:
        showFullCustomer();
        break;

      case 3:
        Runtime.getRuntime().halt(0);
        break;
      default:
        showFullCustomer();
        break;
    }
  }
  private void displayOrderHistory() {
    System.out.println("ENTER THE CUSTOMER ID");
    //final int cusId = option.nextInt();
    //final Orders[] order = OrdersFactory.showCusOrders(cusId);
    System.out.println("CUS_ID" + "\t" + "TOKEN_ID" + "\t" + "ORD_DATE" + "\t" + "ORD_ITEMSELL"
        + "\t" + "ORD_QTY" + "\t" + "ORD_STATUS" + "\t" + "VEN_ID ");
   /*  for (final Orders o : order) {
      System.out.format("%10d %10d %10s %15s %10d %15s %10d %n", o.getcusId(),
          o.gettokenId(), o.getordDate(), o.getordItemSel(), o.getordQty(), o.getordStatus(), o.getVenId());
    } */
  }
  private void showCustWallet() {
    int cusId;
    System.out.println("Enter the customer Id");
    cusId = option.nextInt();
    final Customer c = CustomerFactory.showCusWalletBalance(cusId);
    System.out.println("YOUR WALLET BALANCE : " + c.getcusWallet());
  }
  private void showFullCustomer() {
    System.out.println("Enter the customer Name");
    final String  cusName = option.next();
    CustomerFactory.viewCustomer(cusName);
    final Customer c = CustomerFactory.viewCustomer(cusName);
    System.out.println("CUS_ID" + "\t" + "CUS_PWD" + "\t" + "CUS_NAME" + "\t" + "CUS_DOB" + "\t" + "CUS_PH" + "\t" + "CUS_ADD" + "\t" + "CUS_WALLET");
    System.out.print(c.getcusId() + "\t" + c.getcusPwd() + "\t" + c.getcusName()
          + "\t" + c.getcusDob() + "\t" + c.getcusPh() + "\t" + c.getcusMailAdd() + "\t" + c.getcusWallet());
  }
}
