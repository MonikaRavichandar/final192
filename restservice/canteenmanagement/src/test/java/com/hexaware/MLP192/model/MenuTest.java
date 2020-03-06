
package com.hexaware.MLP192.model;
import com.hexaware.MLP192.persistence.MenuDAO;
import com.hexaware.MLP192.factory.MenuFactory;
//import com.hexaware.MLP192.model.Menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    Menu m = new Menu();
    Menu m100 = new Menu(1, 101, "dosa", 40, 100);
    Menu m101 = new Menu(1, 102, "idly", 20, 100);
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    assertEquals(m100.getfoodId(), new Menu(1, 101, "dosa", 40, 100).getfoodId());
    assertEquals(m101, new Menu(1, 102, "idly", 20, 100));
    assertEquals(m100.hashCode(), new Menu(1, 101, "dosa", 40, 100).hashCode());
    assertEquals(m100, new Menu(1, 101, "dosa", 40, 100));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show();
        result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(1, 101, "dosa", 40, 100);
    final Menu m101 = new Menu(1, 102, "idly", 20, 100);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show();
        result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(1, 101, "dosa", 40, 100).getfoodId(), mn1[0].getfoodId());
    assertEquals(new Menu(1, 102, "idly", 20, 100).getfoodId(), mn1[1].getfoodId());
  }
    /**
  * default constructor testing.
 */
  @Test
  public final  void testDefaultConstructor() {
    Menu newMenu = new Menu();
    assertEquals(newMenu.hashCode(), new Menu().hashCode());
    newMenu.setfoodId(101);
    assertNotEquals(newMenu.getfoodId(), new Menu().getfoodId());
  }
    /**
   * Tests that a list with some employees is handled correctly.
   *
   */
  @Test
  public final void testMenuParameterisedConstructor() {
    Menu newMenu = new Menu(1, 101, "dosa", 40f, 100);
    assertEquals(101, newMenu.getfoodId());
    assertEquals("dosa", newMenu.getfoodItemName());
    assertNotEquals("40", newMenu.getfoodItemAmt());
    assertEquals(100, newMenu.getmVenId());
  }
    /**
   * Tests that a list with some employees is handled correctly.
   *
   */
  @Test
  public final void testMenuSetName() {
    Menu newMenu1 = new Menu(1, 102, "idly", 20f, 100);
    newMenu1.setfoodItemName("idly");
    assertEquals("idly", newMenu1.getfoodItemName());
  }

  /**
   * Tests that a list with some employees is handled correctly.
   *
   */
  @Test
  public final void testMenusetfoodAmt() {
    Menu newMenu1 = new Menu(1, 102, "idly", 20f, 100);
    newMenu1.setfoodAmt(20f);
    assertNotEquals(30f, newMenu1.getfoodItemAmt());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   *
   */
  @Test
  public final void testMenusetVenId() {
    Menu newMenu1 = new Menu(1, 102, "idly", 20f, 100);
    newMenu1.setVenId(100);
    assertNotEquals(200, newMenu1.getmVenId());
  }
}

