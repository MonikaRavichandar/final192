
package com.hexaware.MLP192.persistence;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP192.model.Orders;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrdersMapper class used to fetch menu data from database.
 * @author priyadharshini
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orders
       */
    return new Orders(rs.getInt("CUS_ID"), rs.getInt("TOKEN_ID"), rs.getDate("ORD_DATE"),
        rs.getString("ORD_ITEMSEL"), rs.getInt("ORD_QTY"), rs.getString("ORD_STATUS"), rs.getFloat("ORD_COST"), rs.getInt("VEN_ID"));
  }
}


