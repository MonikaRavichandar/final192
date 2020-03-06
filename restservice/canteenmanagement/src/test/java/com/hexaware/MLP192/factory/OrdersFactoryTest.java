
package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hexaware.MLP192.model.Orders;
import com.hexaware.MLP192.persistence.OrdersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class OrdersFactoryTest {
  /**
   * tests that order is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void updateORDERS(@Mocked final OrdersDAO dao) {
    final Orders c1 = new Orders(0, 0, null, null, 0, null, 0, 0);
    new Expectations() {
      {
        System.out.println("mocked get Orders");
        int c1 = dao.updateORDERS("idli", 1);
        result = c1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int ca = OrdersFactory.updatingORDERS("idli", 1);
    assertNotEquals(c1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showOrders(@Mocked final OrdersDAO dao) {
    final Orders orders = new Orders(0, 0, null, null, 0, null, 0, 0);
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        dao.showOrder();
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showOrders();
    assertNotEquals(orders, actualS);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showOrdersMenu(@Mocked final OrdersDAO dao) {
    final Orders orders = new Orders(101, 0, null, null, 0, null, 0, 0);
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        dao.showCOrders(101);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showCusOrders(101);
    assertNotEquals(orders, actualS);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testGetOrders(@Mocked final OrdersDAO dao) {
    final Orders o = new Orders(5);
    new Expectations() {
      {
        dao.getOrderDetails(5);
        result = o;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    final Orders actualS = OrdersFactory.getOrderDetails(5);
    assertEquals(o, actualS);
  }
 /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testOrdersId(@Mocked final OrdersDAO dao) {
    final Orders o = new Orders(5);
    new Expectations() {
      {
        dao.getOrderId(5);
        result = o;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    final Orders actualS = OrdersFactory.getTokenId(5);
    assertEquals(o, actualS);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updateOrdStatus(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        System.out.println("Mocked find a orders");
        dao.updateOrStatus(100, "ORDER ACCEPTED");
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int updaterU = OrdersFactory.updateOrdStatus(100, "ORDER ACCEPTED");
    assertEquals(1, updaterU);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showValidate(@Mocked final OrdersDAO dao) {
    final Orders orders = new Orders(2);
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        dao.validateOrders(2);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders actualS = OrdersFactory.validateOrder(2);
    assertEquals(orders, actualS);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException is thrown
   */
  @Test
  public final void testSignupCustomer(@Mocked final OrdersDAO dao) throws ParseException {
    final String date2 = "2020-02-13";
    SimpleDateFormat sdf;
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date pDate = sdf.parse(date2);
    new Expectations() {
      {
        final String date2 = "2020-02-13";
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date pDate = sdf.parse(date2);
        java.sql.Date scbod = null;
        scbod = new java.sql.Date(pDate.getTime());
        System.out.println("Mocked find a orders");
        dao.insertorders(107, "idli", 1, scbod, "ORDER ACCEPTED", 40, 100);
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    int signerS = OrdersFactory.insertingorders(107, "idli", pDate, 1, "ORDER ACCEPTED", 40, 100);
    assertEquals(1, signerS);
  }
     /**
  * default constructor testing.
 */
  @Test
public final void testDefaultConstructor() {
    OrdersFactory mf = new OrdersFactory();
    OrdersFactory mf1 = new OrdersFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
   /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void validateshowOrders(@Mocked final OrdersDAO dao) {
    final Orders o2 = new Orders();
    new Expectations() {
      {
        System.out.println("Mocked find a Orders");
        dao.showOrder(100);
        result = o2;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders oaa = OrdersFactory.getOrder(100);
    assertEquals(o2, oaa);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void cancelOrder(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        System.out.println("Mocked find a orders");
        dao.cancelOrder(3, "ORDER ACCEPTED");
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int updaterU = OrdersFactory.cancelOrder(3, "ORDER ACCEPTED");
    assertEquals(1, updaterU);
  }
}
