package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.MenuDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP192.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
/**
   * Call the data base connection.
   * @param foodItemName insert foodItemName.
   * @param foodId insert
   * @param foodAmnt food Amnt
   * @param venId vendor id
   * @param menuId meu id.
   * @return the array of Menu object.
   */
  public static int addMenu(final int menuId, final int foodId, final String foodItemName, final float foodAmnt, final int venId) {
    int i = dao().addingMenu(menuId, foodId, foodItemName, foodAmnt, venId);
    return i;
  }
   /**
   * Call the data base connection.
   * @param foodItemAmt to update Menu status.
   * @param foodId to update Menu status.
   * @return the array of Menu object.
   */
  public static int updateMenu(final int  foodId, final float foodItemAmt) {
    int k = dao().updatingMenu(foodId, foodItemAmt);
    return k;
  }
   /**
   * Call the data base connection.
   * @param foodId to delete Menu name.
   * @return the array of Menu object.
   */
  public static Menu showCost(final int foodId) {
    Menu m = dao().showfoodCost(foodId);
    return m;
  }
     /**
   * Call the data base connection.
   * @param foodId to delete Menu name.
   * @return the array of Menu object.
   */
  public static Menu showFoodName(final int foodId) {
    Menu m = dao().showfName(foodId);
    return m;
  }
   /**
  * @param menuId id
  * @return  customer  bal.
  */
  public static Menu[] showMenuOrders(final int menuId) {
    List<Menu> orders = dao().showMenOrd(menuId);
    return orders.toArray(new Menu[orders.size()]);
  }
  /**
   * Call the data base connection.
   * @param foodItemName to delete Menu name.
   * @return the array of Menu object.
   */
  public static Menu showAmt(final String foodItemName) {
    Menu m = dao().showfoodAmount(foodItemName);
    return m;
  }

}
