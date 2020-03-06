
package com.hexaware.MLP192.persistence;
import java.util.Date;
import java.util.List;

import com.hexaware.MLP192.model.Offers;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * WalletDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OffersDAO {
  /**
     * @return the all the Wallet record.
     */
  @SqlQuery("Select * from Offers")
    @Mapper(OffersMapper.class)
    List<Offers> showWall();
    /**
     * @param cusId for customer id
     * @param venId for wallet balance
     * @param foodName for total amount
     * @param coupCode for payment date
     * @param coupDate for date
     * @param ordId for id
     *  @return the all the Wallet record.
     */
  @SqlUpdate("Insert into Offers(CUS_ID, ORD_ID,VEN_ID, FOOD_NAME, COUP_CODE, COUP_DATE)"
      + " VALUES(:cusId, :ordId, :venId, :foodName, :coupCode, :coupDate)")
int insertingOffers(@Bind("cusId") int cusId, @Bind("ordId") int ordId, @Bind("venId") int venId,
      @Bind("foodName") String foodName, @Bind("coupCode") String coupCode, @Bind("coupDate") Date coupDate);
/**
 * @return the all the Wallet record.
 *  @param cusId for customer id
 * **/
  @SqlQuery("Select * from OFFERS where CUS_ID = :cusId")
  @Mapper(OffersMapper.class)
  Offers gettingCusId(@Bind("cusId") int cusId);
  /**
 * @return the all the Wallet record.
 *  @param cusId for customer id
 * **/
  @SqlQuery("Select * from OFFERS where CUS_ID = :cusId")
  @Mapper(OffersMapper.class)
    Offers gettingDate(@Bind("cusId") int cusId);
}

