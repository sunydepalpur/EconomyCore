package net.tnemc.core.utils.constraints.impl;

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

import net.tnemc.core.utils.constraints.Constraint;

/**
 * Represents a {@link Constraint} of the {@link Integer} type.
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public interface IntConstraint extends Constraint<Integer> {

  @Override
  default Integer convert(final String value) {
    try {
      return Integer.parseInt(value);
    } catch(Exception ignore) {
      return defaultValue();
    }
  }

  @Override
  default boolean validate(final String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch(Exception ignore) {
      return false;
    }
  }
}