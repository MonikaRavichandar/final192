package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP192.model.Vendor;;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from VENDOR")
    @Mapper(VendorMapper.class)
    List<Vendor> showVend();
  /**
   * @param venName insert VENNAME.
   * @param venPwd insert  VENPwd.
   * @param venNo insert VENno.
   * @return the all the Vendor record.
   */
  @SqlUpdate("Insert into Vendor (VEN_NAME, VEN_PWD, VEN_NO)"
      + " values(:venName, :venPwd, :venNo)")
  int signingVendor(@Bind("venName")String venName, @Bind("venPwd")String venPwd, @Bind("venNo")String venNo);
 /**
* @param venName vendor ph
* @param venPwd vendor id
* @return login.
*/
  @SqlQuery("Select * from VENDOR where VEN_NAME = :venName and VEN_PWD = :venPwd")
  @Mapper(VendorMapper.class)
Vendor loginingVendor(@Bind("venName") String venName, @Bind("venPwd") String venPwd);
/**
* @param venWallet customer wallet
* @param venId vendor id
*@return the all the Customer record.
*/
  @SqlUpdate("Update VENDOR SET VEN_WALLET = :venWallet where VEN_ID = :venId")
int updatingVendorWal(@Bind("venId") int venId, @Bind("venWallet") float venWallet);
  /**
*@param venId customer id
* @return login.
*/
  @SqlQuery("Select * from VENDOR where VEN_ID = :venId")
  @Mapper(VendorMapper.class)
Vendor showvenWalBal(@Bind("venId") int venId);

}
