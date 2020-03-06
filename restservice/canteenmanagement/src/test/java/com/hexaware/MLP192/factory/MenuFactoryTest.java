
package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.persistence.MenuDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for Vendor.
 */
public class MenuFactoryTest {
  /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  /**
   * @param dao mocking the dao class
   */

  @Test
    public final void testGetAllMenu(@Mocked final MenuDAO dao) {
    final Menu cb = new Menu(1, 101, "dosa", 40, 100);
    final ArrayList<Menu> menuList = new ArrayList<Menu>();
    new Expectations() {
      {
        menuList.add(cb);
        dao.show();
        result = menuList;
      }
    };

    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    final Menu[] cb1 = MenuFactory.showMenu();
    assertEquals(cb, cb1[0]);
  }

  /**
   * tests that adding menu is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test
  public final void testAddMenu(@Mocked final MenuDAO dao) {
  //final Menu am = new Menu(101, "dosa", 40f, 100);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.addingMenu(1, 101, "dosa", 40f, 100);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    final int am1 = MenuFactory.addMenu(1, 101, "dosa", 40f, 100);
    assertEquals(1, am1);
  }

  /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdatingMenu(@Mocked final MenuDAO dao) {
   // final Menu up = new Menu(101, null, 40f, 0);
    int expected = 1;
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.updatingMenu(101, 40f);
        result = 1;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    final int up1 = MenuFactory.updateMenu(101, 40f);
    assertEquals(expected, up1);
  }
/**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testShowCost(@Mocked final MenuDAO dao) {
   // final Menu up = new Menu(101, null, 40f, 0);
    final Menu cb = new Menu(101);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.showfoodCost(101);
        result = cb;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    final Menu up1 = MenuFactory.showCost(101);
    assertEquals(cb, up1);
  }
  /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testShowFood(@Mocked final MenuDAO dao) {
   // final Menu up = new Menu(101, null, 40f, 0);
    final Menu cb = new Menu(101);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.showfName(101);
        result = cb;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    final Menu up1 = MenuFactory.showFoodName(101);
    assertEquals(cb, up1);
  }
      /**
  * default constructor testing.
 */
  @Test
   public final void testDefaultConstructor() {
    MenuFactory mf = new MenuFactory();
    MenuFactory mf1 = new MenuFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
    /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
  @Test
  public final void showMenuOrder(@Mocked final MenuDAO dao) {
    final Menu orders = new Menu(1, 101, "dosa", 40f, 100);
    new Expectations() {
      {
        System.out.println("Mocked find a Menu");
        dao.showMenOrd(1);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    Menu[] actualS = MenuFactory.showMenuOrders(101);
    assertNotEquals(orders, actualS);
  }*/

}
