package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.MLP192.model.Customer;
import com.hexaware.MLP192.persistence.CustomerDAO;


import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class CustomerFactoryTest {
  private Date pDate = new Date();
  private java.sql.Date scbod = null;
  private SimpleDateFormat sdf;
    /**
     * setup method .
     * @throws ParseException .
     */
  @Before
    public final void initInput() throws ParseException {
      //orders = new Orders();
    final String custdob = "1998-09-12";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    pDate = sdf.parse(custdob);
    scbod = new java.sql.Date(pDate.getTime());
  }
  /**
   * @param dao mocking the dao class
   */

  @Test
  public final void testGetAllCustomer(@Mocked final CustomerDAO dao) {
    final Customer v1 = new Customer(100, "123", "MANOJ", pDate, "9874563211", "manoj@hexaware", 920f);
    final ArrayList<Customer> venList = new ArrayList<Customer>();
    new Expectations() {
      {
        venList.add(v1);
        dao.showCus();
        result = venList;
      }
    };

    new MockUp<CustomerFactory>() {

      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    Customer[] vn1 = CustomerFactory.showCustomer();
    assertEquals(v1, vn1[0]);

  }

  /**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void loginCustomer(@Mocked final CustomerDAO dao) {
    final Customer c1 = new Customer(100, "123", "MANOJ", pDate, "9874563211", "manoj@hexaware", 920f);
    new Expectations() {
          {
            System.out.println("mocked get Customer login");
            dao.loginCus("MANOJ", "manoj@hexaware.com");
            result = c1;
          }
      };
    new MockUp<CustomerFactory>() {
          @Mock
      CustomerDAO dao() {
            System.out.println("Mocked Student Dao");
            return dao;
          }
        };
    Customer ca = CustomerFactory.loginCustomer("MANOJ", "manoj@hexaware.com");
    assertEquals(c1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testShowCusWalletBalance(@Mocked final CustomerDAO dao) {
    final Customer expectedS = new Customer(100, "123", "MANOJ", pDate, "9874563211", "manoj@hexaware", 920f);
    new Expectations() {
          {
            System.out.println("Mocked find a Customer");
            dao.showCusWalBal(101);
            result = expectedS;
          }
        };
    new MockUp<CustomerFactory>() {
          @Mock
      CustomerDAO dao() {
          System.out.println("Mocked Customer Dao");
          return dao;
          }
      };
    Customer actualS = CustomerFactory.showCusWalletBalance(101);
    assertEquals(expectedS, actualS);
  }
/**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateCus(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        dao.updatingCustomer("9874563211", 100);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    int updaterU = CustomerFactory.updateCustomer("9874563211", 100);
    assertEquals(1, updaterU);
  }
 /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateCusBal(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        dao.updatingCustomerWal(100, 920f);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    int updater = CustomerFactory.updateCustomerWalBal(100, 920f);
    assertEquals(1, updater);
  }
   /**
    * tests that customer wallet is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException is thrown
    */
  @Test
   public final void testSignupCustomer(@Mocked final CustomerDAO dao) throws ParseException {
    String date2 = "1998-09-12";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date d1 = sdf.parse(date2);
    final java.sql.Date sdate = new java.sql.Date(d1.getTime());
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        dao.addingCustomer("MANOJ", "123",  sdate, "9874563211", "manoj@hexaware", 920f);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    int signerS = CustomerFactory.insertCustomer("123", "MANOJ", d1, "9874563211", "manoj@hexaware", 920f);
    assertEquals(1, signerS);
  }
   /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testShowCus(@Mocked final CustomerDAO dao) {
    final Customer customer = new Customer(100, "123", "MANOJ", pDate, "9874563211", "manoj@hexaware", 920f);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        //alcust.add(customer);
        dao.showCustomer(100);
        result = customer;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Customer customers = CustomerFactory.showCustomer(100);
    assertEquals(customer, customers);
  }
      /**
  * default constructor testing.
 */
  @Test
  public final void testDefaultConstructor() {
    CustomerFactory mf = new CustomerFactory();
    CustomerFactory mf1 = new CustomerFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }

}

