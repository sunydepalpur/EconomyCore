package net.tnemc.bungee.event;
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

import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.tnemc.bungee.message.MessageManager;

/**
 * PlayerConnectListener
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public class PlayerConnectListener implements Listener {

  @EventHandler
  public void onMessage(ServerSwitchEvent event) {

    if(event.getPlayer().getServer().getInfo().getPlayers().size() <= 1) {
      MessageManager.instance().backlog(event.getPlayer().getServer().getInfo().getSocketAddress().toString());
    }
  }
}
