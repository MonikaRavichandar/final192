package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;


import com.hexaware.MLP192.model.Vendor;
import com.hexaware.MLP192.persistence.VendorDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for Vendor.
 */
public class VendorFactoryTest {
  /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  /**
   * @param dao mocking the dao class
   */

  @Test
  public final void testGetAllVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    final ArrayList<Vendor> venList = new ArrayList<Vendor>();
    new Expectations() {
      {
        venList.add(v1);
        dao.showVend();
        result = venList;
      }
    };

    new MockUp<VendorFactory>() {

      @Mock
      VendorDAO dao() {
        return dao;
      }
    };

    Vendor[] vn1 = VendorFactory.showVendor();
    assertEquals(v1, vn1[0]);

  }
/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void loginVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor("goodfoods", "food123");
    new Expectations() {
      {
        System.out.println("mocked get vendor login");
        dao.loginingVendor("GoodFoods", "goodfoods123");
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor ca = VendorFactory.loginVendor("GoodFoods", "goodfoods123");
    assertEquals(v1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showVenWalletBalance(@Mocked final VendorDAO dao) {
    final Vendor expectedS = new Vendor(100, "GoodFoods", "goodfoods123", "9344552124", 40);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.showvenWalBal(10);
        result = expectedS;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor actualS = VendorFactory.showVenWalletBalance(10);
    assertEquals(expectedS, actualS);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void signupVendor(@Mocked final VendorDAO dao) {
    //final Vendor signS = new Vendor("GoodFoods", "food123", "9344552124");
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.signingVendor("GoodFoods", "goodfoods123", "9344552124");
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int signerS = VendorFactory.signupVendor("GoodFoods", "goodfoods123", "9344552124");
    assertEquals(1, signerS);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updateVendorWalBal(@Mocked final VendorDAO dao) {
    //1final Vendor updateU = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.updatingVendorWal(100, 990);
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int updaterU = VendorFactory.updateVendorWalBal(100, 990);
    assertEquals(1, updaterU);
  }
      /**
  * default constructor testing.
 */
  @Test
   public final void testDefaultConstructor() {
    VendorFactory mf = new VendorFactory();
    VendorFactory mf1 = new VendorFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
}

