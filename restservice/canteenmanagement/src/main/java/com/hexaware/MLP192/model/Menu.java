
package com.hexaware.MLP192.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
  /**
   * foodId,foodItemName,foodItemAmt,cusId.
   */
  private int menuId;
  private int foodId;
  private String foodItemName;
  private Float foodItemAmt;
  private int mvenId;
  /**
   * Default Constructor.
   * @param fid for integer
   */
  public Menu(final int fid) {
    this.foodId = fid;

  }
/**
 * @param argmenuId to initialize menu id.
 * @param argfoodId to initialize food id.
 * @param argfoodItemName to initialize food name.
 * @param argfoodItemAmt to initialize food amount.
 * @param argmvenId to initialize customer Id.
 * used to get details through constructor.
 */
  public Menu(final int argmenuId, final int argfoodId, final String argfoodItemName, final float argfoodItemAmt, final int argmvenId) {
    this.mvenId = argmenuId;
    this.foodId = argfoodId;
    this.foodItemName = argfoodItemName;
    this.foodItemAmt = argfoodItemAmt;
    this.mvenId = argmvenId;
  }
/**
 * @par to initialize food id.
 */
  public Menu() {
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Menu menu = (Menu) obj;
    if (Objects.equals(menuId, menu.menuId) || Objects.equals(foodId, menu.foodId) || Objects.equals(foodItemName, menu.foodItemName)
        || Objects.equals(foodItemAmt, menu.foodItemAmt) || Objects.equals(mvenId, menu.mvenId)) {
      return true;
    }
    return false;
  }

  @Override

     public final int hashCode() {
    return Objects.hash(menuId, foodId, foodItemName, foodItemAmt, mvenId);
  }
  /**
* @return this food Id.
*/
  public final int getmenuId() {
    return menuId;
  }
/**
* @return this food Id.
*/
  public final int getfoodId() {
    return foodId;
  }
  /**
* @return this food Item name.
*/
  public final String getfoodItemName() {
    return foodItemName;
  }
/**
* @return this food amrt.
*/
  public final Float getfoodItemAmt() {
    return foodItemAmt;
  }
/**
* @return this cus Id.
*/
  public final int getmVenId() {
    return mvenId;
  }
  /**
   * @param argmenuId gets the food id.
   */
  public final void setmenuId(final int argmenuId) {
    this.menuId = argmenuId;
  }
  /**
   * @param argfoodId gets the food id.
   */
  public final void setfoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }
  /**
   * @param argfoodItemName gets the food name.
   */
  public final void setfoodItemName(final String argfoodItemName) {
    this.foodItemName = argfoodItemName;
  }
  /**
   * @param argfoodItemAmt gets the food amount.
   */
  public final void setfoodAmt(final float argfoodItemAmt) {
    this.foodItemAmt = argfoodItemAmt;
  }
  /**
   * @param argmvenId gets the customer Id.
   */
  public final void setVenId(final int argmvenId) {
    this.mvenId = argmvenId;

  }
}
