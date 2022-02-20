package net.tnemc.core.currency.type;

import net.tnemc.core.account.Account;
import net.tnemc.core.currency.Currency;
import net.tnemc.core.currency.CurrencyType;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * The New Economy Minecraft Server Plugin
 * <p>
 * Created by creatorfromhell on 8/5/2019.
 * <p>
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by creatorfromhell on 06/30/2017.
 */
public class VirtualType implements CurrencyType {
  /**
   * @return The name of this currency type. Examples: Virtual, Item
   */
  @Override
  public String name() {
    return "virtual";
  }

  /**
   * @return True if this currency requires setting the player's balance when they log in. This should be true for currency
   * types like item currency.
   */
  @Override
  public boolean loginCalculation() {
    return false;
  }

  /**
   * Used to get the holdings for a specific account from this currency type.
   *
   * @param account  The uuid of the account.
   * @param world    The name of the world.
   * @param currency The instance of the currency to use.
   * @param database True if the holdings should be taken from the database vs the inventory, if applicable.
   * @return The holdings for the specific account.
   */
  @Override
  public BigDecimal getHoldings(Account account, String world, Currency currency, boolean database) throws SQLException {
    return account.getHoldingsManager().getHoldings(world, currency);
  }

  /**
   * @param account
   * @param world    The world to use for saving the holdings.
   * @param currency The instance of the currency to use.
   * @param amount   The amount to set the player's holdings to.
   * @param skipUpdate   Whether or not to skip updating. For item-based currency this skips updating the inventory.
   */
  @Override
  public void setHoldings(Account account, String world, Currency currency, BigDecimal amount, boolean skipUpdate) throws SQLException {
    account.getHoldingsManager().setHoldings(world, currency.getIdentifier(), amount, !skipUpdate);
  }
}