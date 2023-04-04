package net.tnemc.core.handlers;

/*
 * The New Economy
 * Copyright (C) 2022 - 2023 Daniel "creatorfromhell" Vidmar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import net.tnemc.core.TNECore;
import net.tnemc.core.account.Account;
import net.tnemc.core.compatibility.PlayerProvider;
import net.tnemc.core.currency.Currency;
import net.tnemc.core.currency.item.ItemCurrency;
import net.tnemc.core.utils.HandlerResponse;

import java.util.Optional;

/**
 * Represents an event where a player is joining.
 *
 * @since 0.1.2
 * @author creatorfromhell
 */
public class PlayerJoinHandler {

  /**
   * Used to handle a PlayerJoinEvent using the specified {@link PlayerProvider} class.
   * @param provider The {@link PlayerProvider} associated with the platform event.
   * @return True if the event should be cancelled, otherwise false.
   */
  public HandlerResponse handle(PlayerProvider provider) {
    final HandlerResponse response = new HandlerResponse("", false);

    final Optional<Account> account = TNECore.eco().account().findAccount(provider.identifier());

    //Our account doesn't exist, so now we need to continue from here
    if(account.isEmpty() &&
        !TNECore.eco().account().createAccount(provider.identifier().toString(), provider.getName()).success()) {

      response.setResponse(response.getResponse());
      response.setCancelled(true);
      return response;
    }

    for(Currency currency : TNECore.eco().currency().currencies()) {
      if(currency instanceof ItemCurrency) {

        //TODO: Check item currency balances.
      }
    }

    //TODO: Check for transactions that happened while away if player has notify settings active.

    if(provider.hasPermission("tne.admin.update")) {
      //TODO: Update check.

      //TODO: Any warnings? Balance jumps?
    }

    return response;
  }
}