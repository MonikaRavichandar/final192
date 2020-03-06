package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP192.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from MENU")
    @Mapper(MenuMapper.class)
    List<Menu> show();
     /**
     * @return the all the Vendor record.
     * @param foodItemName insert foodItemName.
     * @param foodAmnt amount of food
     * @param venId vendor id
     * @param foodId insert food id
     * @param menuId menu id.
     */
  @SqlUpdate("Insert into MENU(MENU_ID, FOOD_ID, FOOD_ITEMNAME, FOOD_ITEMAMT, VEN_ID)"
      + " Values(:menuId, :foodId, :foodItemName, :foodAmnt, :venId)")
   int addingMenu(@Bind("menuId")int menuId, @Bind("foodId")int foodId, @Bind("foodItemName")String foodItemName,
        @Bind("foodAmnt")float foodAmnt, @Bind("venId")int venId);
  /**
   * @param foodItemName delete foodItemName.
   * @return the all the Menu record.
   */
  @SqlUpdate("Delete FROM  MENU where FOOD_ITEMNAME = :foodItemName")
  int deletingMenu(@Bind("foodItemName")String foodItemName);
  /**
   * @param  foodItemAmt update foodItemAmt.
   * @param  foodId update foodId.
   *  @return the all the Vendor record.
   */
  @SqlUpdate("Update MENU set FOOD_ITEMAMT = :foodItemAmt where FOOD_ID = :foodId")
  int updatingMenu(@Bind("foodId") int foodId, @Bind("foodItemAmt") float foodItemAmt);
  /**
   * @param  foodId update foodItemAmt.
   *  @return the all the Vendor record.
   */
  @SqlQuery("select * from MENU where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
  Menu showfoodCost(@Bind("foodId") int foodId);
  /**
   * @param  foodId update foodItemName.
   *  @return the all the Vendor record.
   */
  @SqlQuery("select * from MENU where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
  Menu showfName(@Bind("foodId") int foodId);
    /**
   * @param menuId for order id.
   * @return the cust Id.
   */
  @SqlQuery("select * from MENU where MENU_ID = :menuId")
  @Mapper(MenuMapper.class)
  List<Menu> showMenOrd(@Bind("menuId") int menuId);
  /**
   * @param  foodItemName update foodItemAmt.
   *  @return the all the Vendor record.
   */
  @SqlQuery("select * from MENU where FOOD_ITEMNAME = :foodItemName")
  @Mapper(MenuMapper.class)
  Menu showfoodAmount(@Bind("foodItemName") String foodItemName);
}
