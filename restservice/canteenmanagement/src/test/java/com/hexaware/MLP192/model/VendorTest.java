package com.hexaware.MLP192.model;

import com.hexaware.MLP192.persistence.VendorDAO;
import com.hexaware.MLP192.factory.VendorFactory;
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
public class VendorTest {
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
  public final void testVendor() {
    Vendor v1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    Vendor v2 = new Vendor(102, "ramfoods", "food456", "9884497960", 50);
    assertNotEquals(v1, null);
    assertNotEquals(v2, null);
    assertEquals(v1.getVenId(), new Vendor(101, "goodfoods", "food123", "9344552124", 40).getVenId());
    assertEquals(v1.getVenName(), new Vendor(101, "goodfoods", "food123", "9344552124", 40).getVenName());
    assertEquals(v1.getVenNo(), new Vendor(101, "goodfoods", "food123", "9344552124", 40).getVenNo());
    assertEquals(v1.getVenPwd(), new Vendor(101, "goodfoods", "food123", "9344552124", 40).getVenPwd());
    v1.setVenId(102);
    v2.setVenName("ramfoods");
    v2.setVenNo("9884497960");
    v2.setVenPwd("food456");
    assertNotEquals(v2, new Vendor(101, "goodfoods", "food123", "9344552124", 40));
    assertNotEquals(v1.hashCode(), new Vendor(101, "goodfoods", "food123", "9344552124", 40).hashCode());
    assertEquals(v1, new Vendor(101, "goodfoods", "food123", "9344552124", 40));
  }
 /**
   * tests that empty vendor list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.showVend();
        result = new ArrayList<Vendor>();
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    final Vendor[] me = VendorFactory.showVendor();
    assertEquals(0, me.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    final Vendor v2 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    final ArrayList<Vendor> vn = new ArrayList<Vendor>();
    new Expectations() {
      {
        vn.add(v1);
        vn.add(v2);
        dao.showVend();
        result = vn;
      }
    };
    new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
          return dao;
        }
      };
    final Vendor[] vn1 = VendorFactory.showVendor();
    assertEquals(2, vn1.length);
    assertEquals(new Vendor(101, "goodfoods", "food123", "9344552124", 40).getVenId(),
        vn1[0].getVenId());
    assertNotEquals(new Vendor(102, "ramfoods", "food456", "9884497960", 50).getVenId(),
        vn1[1].getVenId());

  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorDefaultConstructor() {
    Vendor newVendor = new Vendor();
    assertEquals(newVendor.hashCode(), newVendor.hashCode());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorParameterisedconstructor() {
    Vendor newVendor = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    assertEquals(101, newVendor.getVenId());
    assertEquals("goodfoods", newVendor.getVenName());
    assertEquals("food123", newVendor.getVenPwd());
    assertEquals("9344552124", newVendor.getVenNo());
    assertEquals(40, newVendor.getVenWallet(), 0.001);

  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorsetName() {
    Vendor newvendor1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    newvendor1.setVenName("preethamfoods");
    assertEquals("preethamfoods", newvendor1.getVenName());

  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorsetpwd() {
    Vendor newvendor1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    newvendor1.setVenPwd("cook123");
    assertEquals("cook123", newvendor1.getVenPwd());

  }
   /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorsetNo() {
    Vendor newvendor1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    newvendor1.setVenNo("9884497960");
    assertEquals("9884497960", newvendor1.getVenNo());

  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
  public final void testVendorsetWallet() {
    Vendor newvendor1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    newvendor1.setVenWallet(40);
    assertEquals(40, newvendor1.getVenWallet(), 0.001);

  }
}
