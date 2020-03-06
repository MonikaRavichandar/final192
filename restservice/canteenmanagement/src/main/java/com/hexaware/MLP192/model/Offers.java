package com.hexaware.MLP192.model;
import java.util.Objects;
import java.util.Date;
/**
 * Wallet class used to display wallet information.
 * @author hexware
 */

public class Offers {

  private int fcusId;
  private int fordId;
  private int fvenId;
  private String food;
  private String coupCode;
  private Date coupDate;
   /**
   * Default Constructor.
   */
  public Offers() {
  }

  /**
   * @param argCusId      to initialize customer id
   * @param argOrdId     to initialize wallet balance
   * @param argVenId    to intialize wallet pay id
   * @param argFood   to intialize wallet paytime
   * @param argCoupCode   to initialize wallet paydate
   * @param argCoupDate    to intialize wallet totamt
   */
  public Offers(final int argCusId, final int argOrdId, final int argVenId, final String argFood,
      final String argCoupCode, final Date argCoupDate) {
    this.fcusId = argCusId;
    this.fordId = argOrdId;
    this.fvenId = argVenId;
    this.food = argFood;
    this.coupCode = argCoupCode;
    this.coupDate = argCoupDate;

  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Offers bal = (Offers) obj;
    if (Objects.equals(fcusId, bal.fcusId) || Objects.equals(fordId, bal.fordId) || Objects.equals(fvenId, bal.fvenId)
          || Objects.equals(food, bal.food) || Objects.equals(coupCode, bal.coupCode) || Objects.equals(coupDate, bal.coupDate)) {
      return true;
    }
    return false;
  }

  @Override
    public final int hashCode() {
    return Objects.hash(fcusId, fordId, fvenId, food, coupCode, coupDate);
  }
  /**
     * @return this cusId.
     */
  public final int getCusId() {
    return fcusId;
  }
  /**
     * @return this walBal.
     */
  public final int getOrdId() {
    return fordId;
  }
  /**
     * @return this walPayid.
     */
  public final int getVenId() {
    return fvenId;
  }
  /**
     * @return this walTotamt.
     */
  public final String getFood() {
    return food;
  }
  /**
     * @return this walPaydate.
     */
  public final Date getCoupDate() {
    return coupDate;
  }
  /**
     * @return this walPaytime.
     */
  public final String getCoupCode() {
    return coupCode;
  }
    /**
     * @param argCusId gets the cus id.
     */
  public final void setCusId(final int argCusId) {
    this.fcusId = argCusId;
  }
  /**
     * @param argOrdId gets the wal bal.
     */
  public final void setOrdId(final int argOrdId) {
    this.fordId = argOrdId;
  }
  /**
     * @param argVenId gets the wal pay id.
     */
  public final void setVenId(final int argVenId) {
    this.fvenId = argVenId;
  }
  /**
     * @param argFood the wal tot amt.
     */
  public final void setFood(final String argFood) {
    this.food = argFood;
  }
  /**
 * @param argCoupCode gets the wal pay date.
  */
  public final void setCoupCode(final String argCoupCode) {
    this.coupCode = argCoupCode;
  }
  /**
     * @param argCoupDate gets the wal pay time.
     */
  public final void setCoupDate(final Date argCoupDate) {
    this.coupDate = argCoupDate;
  }

}
