package com.hexaware.MLP192.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.factory.MenuFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }
   /**
   * Returns Menu details.
   * @param foodId food id.
   * @return the menu details
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showFoodName/{foodId}")
  public final Menu showFoodName(@PathParam("foodId") final int foodId) {
    final Menu menu = MenuFactory.showFoodName(foodId);
    return menu;
  }*/
      /**
   * Returns Menu details.
   * @param foodItemName food id.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showAmt/{foodItemName}")
  public final Menu showAmt(@PathParam("foodItemName") final String foodItemName) {
    final Menu menu = MenuFactory.showAmt(foodItemName);
    return menu;
  }
        /**
   * updates Menu details.
   * @param newMenu new menu.
   * @return the menu details
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateMenu")
  public final String updateMenu(final Menu newMenu) {
    String comment = "";
    final int menuUpdate = MenuFactory.updateMenu(newMenu.getfoodId(), newMenu.getfoodItemAmt());
    if (menuUpdate > 0) {
      comment = "{\" value \" : \" menu updated successfully \"}";
    } else {
      comment = "{\" value \" : \" menu not updated  \"}";
    }
    return comment;
  }
          /**
   * inserts Menu details.
   * @param newMenu new menu.
   * @return the menu details
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addMenu")
  public final String addMenu(final Menu newMenu) {
    String comment = "";
    final int menuIns = MenuFactory.addMenu(newMenu.getmenuId(),
        newMenu.getfoodId(), newMenu.getfoodItemName(), newMenu.getfoodItemAmt(), newMenu.getmVenId());
    if (menuIns > 0) {
      comment = "{\" value \" : \" Menu added successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu not added  \"}";
    }
    return comment;

  }
}
