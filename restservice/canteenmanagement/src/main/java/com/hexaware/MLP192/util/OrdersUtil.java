
package com.hexaware.MLP192.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import com.hexaware.MLP192.factory.CustomerFactory;
import com.hexaware.MLP192.factory.MenuFactory;
import com.hexaware.MLP192.factory.OffersFactory;
import com.hexaware.MLP192.factory.OrdersFactory;
import com.hexaware.MLP192.factory.VendorFactory;
import com.hexaware.MLP192.model.Customer;
import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.model.Offers;
import com.hexaware.MLP192.model.Orders;
import com.hexaware.MLP192.model.Vendor;

/**
 * CustomerUtil.java used as Client interface for java coding.
 * @Monika-hexware
 */
class OrdersUtil {
  private static Scanner option = new Scanner(System.in, "UTF-8");

  private void showFullOrder() {
    final Orders[] orders = OrdersFactory.showOrders();
    System.out.println(
        "CUS_ID" + "\t" + "ORD_ID" + "\t" + "ORD_DATE" + "\t" + "ORD_ITEMSELL" + "\t" + "ORD_QTY" + "ORD_STATUS");
    for (final Orders o : orders) {
      System.out.format("%10d %10d %10s %15s %10d %15s %n", o.getcusId(), o.gettokenId(), o.getordDate(),
          o.getordItemSel(), o.getordQty(), o.getordStatus());
    }

  }
  /**
   * CliMain used as Client interface for java coding.
   * @Magudi-hexware
   */
  public void showFullMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "ven_Id");
    for (final Menu m : menu) {
      System.out.format("%3d %15s %15f %10s %n", m.getfoodId(), m.getfoodItemName(), m.getfoodItemAmt(), m.getmVenId());
    }
  }

  /**
   * CliMain used as Client interface for java coding.
   * @Magudi-hexware
   */
  public void showVegMenu() {
    final Menu[] menu = MenuFactory.showMenuOrders(1);
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "ven_Id");
    for (final Menu m : menu) {
      System.out.format("%3d %15s %15f %10s %n", m.getfoodId(), m.getfoodItemName(), m.getfoodItemAmt(), m.getmVenId());
    }
  }
  /**
   * CliMain used as Client interface for java coding.
   * @Magudi-hexware
   */
  public void showNonVegMenu() {
    final Menu[] menu = MenuFactory.showMenuOrders(2);
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "ven_Id");
    for (final Menu m : menu) {
      System.out.format("%3d %15s %15f %10s %n", m.getfoodId(), m.getfoodItemName(), m.getfoodItemAmt(), m.getmVenId());
    }
  }

  /**
   * CliMain used as Client interface for java coding.
   * @throws ParseException throws
   * @Magudi-hexware
   */
  public void showPlaceOrder() throws ParseException {
    System.out.println("Enter 1 for Veg");
    System.out.println("Enter 2 for Non-Veg");
    System.out.println("Enter 3 for Veg and Non-Veg");
    int op = option.nextInt();
    switch (op) {
      case 1:
        showVegMenu();
        break;
      case 2:
        showNonVegMenu();
        break;
      case 3:
        showFullMenu();
        break;
      default:
        Runtime.getRuntime().halt(0);
    }
    int cusId;
    String ordStatus;
    System.out.println("Enter the customer Id");
    cusId = option.nextInt();
    Customer q = CustomerFactory.showCustomer(cusId);
    if (q != null) {
      Customer c = CustomerFactory.showCusWalletBalance(cusId);
      System.out.println("YOUR WALLET BALANCE : " + c.getcusWallet());
      System.out.println("ENTER FOOD ID");
      int foodId = option.nextInt();
      Menu m = MenuFactory.showCost(foodId);
      if (foodId == m.getfoodId()) {
        System.out.println("ENTER THE QUANTITY");
        int foodquan = option.nextInt();
        float foodcost = m.getfoodItemAmt();
        float ordertotcost = foodcost * foodquan;
        float cuswalbal = c.getcusWallet();
        if (cuswalbal < ordertotcost) {
          System.out.println("INSUFFICIENT BALANCE");
          ordStatus = "ORDER NOT PLACED ";
        } else {
          System.out.println("YOU HAVE SELECTED THE FOOD : " + m.getfoodId());
          System.out.println("Enter the vendor Id");
          int venId = option.nextInt();
          Vendor v = VendorFactory.showVenWalletBalance(venId);
          float venwalbal = v.getVenWallet();
          MenuFactory.showFoodName(foodId);
          String ordItemSel = m.getfoodItemName();
          venwalbal = venwalbal + ordertotcost;
          VendorFactory.updateVendorWalBal(venId, venwalbal);
          v.setVenWallet(venwalbal);
          Offers f = OffersFactory.getOfCusId(cusId);
          if (f != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String dat =  sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 10);
            String endDate = sdf.format(cal.getTime());
            Date d1 = sdf.parse(dat);
            Date d2 = sdf.parse(endDate);
            if (d1.compareTo(d2) < 0) {
              System.out.println("YOU ARE ALREADY HAVE COUPON");
              float cost = ordertotcost;
              if (cost > 100) {
                float totCost = cost - 100;
                Customer ct = CustomerFactory.showCusWalletBalance(cusId);
                float customerWal = ct.getcusWallet() - totCost;
                CustomerFactory.updateCustomerWalBal(cusId, customerWal);
                c.setcusWall(cuswalbal);
                System.out.println("SUCCESFULLY PLACED ORDER AND THE TOTAL COST  Is : " + ordertotcost);
                System.out.println("FOR YOUR COUPON YOU GOT 100RS DISCOUNT AND YOUR ORDER COST IS " + totCost);
                System.out.println("YOUR WALLET BALANCE IS" + customerWal);
                ordStatus = "ORDER PLACED";
                OrdersFactory.insertingorders(cusId, ordItemSel, d1, foodquan, ordStatus, totCost, venId);
              } else {
                System.out.println("PURCHASE ABOVE 200 TO USE COUPON");
              }
            } else {
              System.out.println("TOTAL COST IS : " + ordertotcost);
              cuswalbal = cuswalbal - ordertotcost;
              CustomerFactory.updateCustomerWalBal(cusId, cuswalbal);
              c.setcusWall(cuswalbal);
              System.out.println("SUCCESFULLY PLACED ORDER AND THE WALLET BALANCE Is : " + cuswalbal);
              ordStatus = "ORDER PLACED";
              OrdersFactory.insertingorders(cusId, ordItemSel, d1, foodquan, ordStatus, ordertotcost, venId);
            }
          } else {
            System.out.println("GOOD NEWS!!!!!!! YOU HAVE A COUPON FOR THIS ORDER");
            String coupon = "FREE2020";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String dat =  sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 10);
            Date d1 = sdf.parse(dat);
            String endDate = sdf.format(cal.getTime());
            Date d2 = sdf.parse(endDate);
            System.out.println("YOUR WON THE COUPON -FREE2020- WHICH VALIDATES UPTO: " + d2);
            System.out.println("TOTAL COST IS : " + ordertotcost);
            cuswalbal = cuswalbal - ordertotcost;
            CustomerFactory.updateCustomerWalBal(cusId, cuswalbal);
            c.setcusWall(cuswalbal);
            System.out.println("SUCCESFULLY PLACED ORDER AND THE WALLET BALANCE Is : " + cuswalbal);
            ordStatus = "ORDER PLACED";
            OrdersFactory.insertingorders(cusId, ordItemSel, d1, foodquan, ordStatus, ordertotcost, venId);
            Orders or = OrdersFactory.getTokenId(cusId);
            OffersFactory.insertOffers(cusId, or.gettokenId(), venId, ordItemSel, coupon, d1);
          }
        }
      }
      System.out.println("ARE YOU STILL HUNGRY----->WANT TO PLACE ANOTHER ORDER(Y/N)?");
      String rePlace = option.next().toUpperCase();
      if (rePlace.equals("Y")) {
        showFullMenu();
      } else {
        System.out.println("Thank you ... come again");
      }
    } else {
      System.out.println("Enter the valid customer Id");
    }
  }

  /**
  * CliMain used as Client interface for java coding.
  * @Magudi-hexware
   */
  public  void venValidation() {
    showFullOrder();
    int tokenId;
    System.out.println("Enter the customer Id");
    int cusId = option.nextInt();
    System.out.println("ENTER  TOKEN ID:");
    tokenId = option.nextInt();
    Orders o = OrdersFactory.validateOrder(tokenId);
    System.out.println(o.getVenId());
    if (tokenId == o.gettokenId()) {
      System.out.println("ENTER 1 TO ACCEPT THE ORDER");
      System.out.println("ENTER 2 TO REJECT THE ORDER");
      int accRej = option.nextInt();
      switch (accRej) {
        case 1:
          System.out.println("ORDER SUCESSFULLY ACCEPTED");
          String ordStatus = "ORDER ACCEPTED";
          OrdersFactory.updateOrdStatus(cusId, ordStatus);
          break;
        case 2:
          OrdersFactory.getOrderDetails(tokenId);
          cusId = o.getcusId();
          Customer ct = CustomerFactory.showCusWalletBalance(cusId);
          float walletBalance = ct.getcusWallet() + o.getordCost();
          System.out.println("ENTER THE VENDOR ID:");
          int venId = option.nextInt();
          Vendor v = VendorFactory.showVenWalletBalance(venId);
          float venwalbal = v.getVenWallet();
          venwalbal = venwalbal - o.getordCost();
          VendorFactory.updateVendorWalBal(venId, venwalbal);
          v.setVenWallet(venwalbal);
          CustomerFactory.updateCustomerWalBal(o.getcusId(), walletBalance);
          System.out.println("Order Rejected ");
          ordStatus = "ORDER REJECTED";
          OrdersFactory.updateOrdStatus(cusId, ordStatus);
          break;
        default:
          Runtime.getRuntime().halt(0);
      }
    } else {
      System.out.println("ENTER THE VALID ORDER ID");
    }
  }
}
