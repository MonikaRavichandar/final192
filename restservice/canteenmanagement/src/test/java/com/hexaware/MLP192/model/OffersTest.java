package com.hexaware.MLP192.model;

import com.hexaware.MLP192.persistence.OffersDAO;
import com.hexaware.MLP192.factory.OffersFactory;


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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Offers.
 */
@RunWith(JMockit.class)
public class OffersTest {
  private Date d1 = new Date();
  private Date d2 = new Date();
  private SimpleDateFormat sdf;
  /**
   * tests that empty employee list is handled correctly.
   * @throws ParseException exception.
   */
  @Before
  public final void initInput() throws ParseException {
    String date1 = "2020/09/09";
    String date2 = "2020/07/05";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    d2 = sdf.parse(date2);
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
public final void testOffers() {
    Offers oFF06 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    Offers oFF07 = new Offers(100, 102, 2, "soup", "FREE2020", d2);
    assertNotEquals(oFF06, null);
    assertNotEquals(oFF07, null);
    assertEquals(oFF06.getCoupCode(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCoupCode());
    assertEquals(oFF06.getFood(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getFood());
    assertEquals(oFF06.getCusId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCusId());
    assertEquals(oFF06.getVenId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getVenId());
    assertEquals(oFF06.getOrdId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getOrdId());
    assertEquals(oFF06.getCoupDate(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCoupDate());
    oFF07.setCoupCode("Free2020");
    oFF07.setCusId(13);
    oFF07.setFood("soup");
    oFF07.setVenId(100);
    oFF07.setOrdId(102);
    assertEquals(oFF06, new Offers(100, 102, 2, "soup", "FREE2020", d1));
    assertEquals(oFF06.hashCode(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).hashCode());
    assertEquals(oFF06, new Offers(100, 102, 2, "soup", "FREE2020", d1));
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OffersDAO dao) {
    new Expectations() {
      {
        dao.showWall(); result = new ArrayList<Offers>();
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] of = OffersFactory.showOffers();
    assertEquals(0, of.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OffersDAO dao) {
    final Offers oFF06 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    final Offers oFF07 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    final ArrayList<Offers> oa = new ArrayList<Offers>();
    new Expectations() {
      {
        oa.add(oFF06);
        oa.add(oFF07);
        dao.showWall(); result = oa;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] oa1 = OffersFactory.showOffers();
    assertEquals(2, oa1.length);
    assertEquals(new Offers(100, 102, 2, "soup", "FREE2020", d2).getCoupCode(),
        oa1[0].getCoupCode());
    assertEquals(new Offers(100, 102, 2, "soup", "FREE2020", d2).getCoupCode(),
        oa1[1].getCoupCode());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
  @Test
public final void testOffersdefaultConstructor() {
    Offers ob = new Offers();
    assertEquals(ob.hashCode(), new Offers().hashCode());
  }
  /**
   * Tests that a list with some employees is handled correctly.
 * @throws ParseException exception.
   */
  @Test
public final void testOffersParameterisedConstructor() throws ParseException {
   //Date d = new Date("");
    String date3 = "2020/02/24";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    Date d3 = sdf.parse(date3);
    Offers ob = new Offers(100, 103, 2, "Dosa", "FREE2020", d3);
    //testing car variables are intialized through getters which in turn to know where its returning a correct values
    assertEquals(100, ob.getCusId());
    assertEquals(103, ob.getOrdId());
    assertEquals(2, ob.getVenId());
    assertEquals("Dosa", ob.getFood());
    assertEquals("FREE2020", ob.getCoupCode());
    assertEquals(d3, ob.getCoupDate());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   */
    /**
   * default constructor testing.
   */
  @Test
  public final void testOfferssetpwd() {
    Offers newoffer1 = new Offers(100, 103, 2, "Dosa", "FREE2020", d1);
    newoffer1.setCusId(100);
    assertEquals(100, newoffer1.getCusId());
    newoffer1.setOrdId(103);
    assertEquals(103, newoffer1.getOrdId());
    newoffer1.setVenId(2);
    assertEquals(2,  newoffer1.getVenId());
    newoffer1.setFood("Dosa");
    assertEquals("Dosa", newoffer1.getFood());
    newoffer1.setCoupCode("FREE2020");
    assertEquals("FREE2020",  newoffer1.getCoupCode());
    newoffer1.setCoupDate(d1);
    assertEquals(d1,  newoffer1.getCoupDate());
  }
 /**
 * Tests that a list with some employees is handled correctly.
 */
}

