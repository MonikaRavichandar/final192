package com.hexaware.MLP192.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP192.model.Offers;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * offersMapper class used to fetch offers data from database.
 * @author hexware
 */
public class OffersMapper implements ResultSetMapper<Offers> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
    */
  public final Offers map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
      *@return offers
      */
    return new Offers(rs.getInt("CUS_ID"), rs.getInt("ORD_ID"), rs.getInt("VEN_ID"),
      rs.getString("FOOD_NAME"), rs.getString("COUP_CODE"), rs.getDate("COUP_DATE"));
  }
}

