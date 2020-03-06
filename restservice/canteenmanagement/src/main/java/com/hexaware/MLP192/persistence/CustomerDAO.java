
package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.sql.Date;
import java.util.List;

import com.hexaware.MLP192.model.Customer;

/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from CUSTOMER")
    @Mapper(CustomerMapper.class)
    List<Customer> showCus();
      /**
  * @param cusPwd customer password
  * @param cusName customer name
  * @param od customer date
  * @param cusPh customer ph
  * @param cusMailAdd customer add
  * @param cusWallet customer wallet
  * @return values
  */
  @SqlUpdate("Insert into Customer (CUS_NAME, CUS_PWD, CUS_DOB, CUS_PH, CUS_MAILADD, CUS_WALLET)"
      + " values(:cusName, :cusPwd, :od, :cusPh, :cusMailAdd, :cusWallet)")
int addingCustomer(@Bind("cusName")String cusName, @Bind("cusPwd")String cusPwd,
       @Bind("od")Date od, @Bind("cusPh")String cusPh, @Bind("cusMailAdd")String cusMailAdd, @Bind("cusWallet")float cusWallet);
/**
* @param cusPh customer ph
* @param cusId customer id
*@return the all the Customer record.
*/
  @SqlUpdate("Update Customer SET CUS_PH = :cusPh where CUS_ID = :cusId")
int updatingCustomer(@Bind("cusPh") String cusPh, @Bind("cusId") int cusId);
/**
* @param cusName customer ph
* @param cusPwd customer id
* @return login.
*/
  @SqlQuery("Select * from CUSTOMER where CUS_NAME = :cusName and CUS_PWD = :cusPwd")
  @Mapper(CustomerMapper.class)
    Customer loginCus(@Bind("cusName") String cusName, @Bind("cusPwd") String cusPwd);
    /**
*@param cusId customer id
* @return login.
*/
  @SqlQuery("Select * from CUSTOMER where CUS_ID = :cusId")
  @Mapper(CustomerMapper.class)
    Customer showCusWalBal(@Bind("cusId") int cusId);
    /**
* @param cusWallet customer wallet
* @param cusId customer id
*@return the all the Customer record.
*/
  @SqlUpdate("Update Customer SET CUS_WALLET = :cusWallet where CUS_ID = :cusId")
  int updatingCustomerWal(@Bind("cusId") int cusId, @Bind("cusWallet") float cusWallet);

     /**
*@param cusName customer id
* @return login.
*/
  @SqlQuery("Select * from CUSTOMER where CUS_NAME = :cusName")
  @Mapper(CustomerMapper.class)
  Customer showCustomer(@Bind("cusName") String cusName);
     /**
*@param cusName customer id
* @return login.
*/
  @SqlQuery("Select * from CUSTOMER where CUS_ID = :cusName")
  @Mapper(CustomerMapper.class)
  Customer showCustomer(@Bind("cusName") int cusName);
}
