package net.tnemc.core.setup.impl;

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

import net.tnemc.core.setup.Step;

import java.util.Arrays;
import java.util.List;

/**
 * ReadOfflineInventoryStep - Reads offline inventories to convert existing items to item currencies.
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public class ReadOfflineInventoryStep implements Step {

  /**
   * The human-friendly identifier for this step.
   *
   * @return the human-friendly identifier for this step.
   */
  @Override
  public String identifier() {
    return "offline-inventory";
  }

  @Override
  public List<String> after() {
    return Arrays.asList("conversion", "offline");
  }

  /**
   * Runs this step.
   *
   * @return True if this step ran successfully, otherwise false.
   */
  @Override
  public boolean run() {
    return false;
  }
}