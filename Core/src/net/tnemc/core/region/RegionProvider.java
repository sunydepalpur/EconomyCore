package net.tnemc.core.region;
/*
 * The New Economy
 * Copyright (C) 2022 Daniel "creatorfromhell" Vidmar
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

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A class that contains information related to regions such as configs, and region-sharing naming.
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public class RegionProvider {

  public final Map<String, String> sharing = new HashMap<>();
  public final Map<String, RegionGroup> regions = new HashMap<>();

  private boolean realmSharing;

  public RegionProvider(boolean realmSharing) {
    this.realmSharing = realmSharing;
  }

  public void initializeRegion(final String name, final RegionType type) {

  }

  /**
   * Used to add a region group to our existing map of groups.
   * @param name The name of the group
   * @param group The group instance.
   */
  public void addGroup(final String name, final RegionGroup group) {
    regions.put(name, group);
  }

  /**
   * Used to find a region group based on its name.
   * @param name The name of the group to find.
   * @return An optional containing the {@link RegionGroup} if it exists, otherwise an empty optional.
   */
  public Optional<RegionGroup> retrieve(final String name) {
    return Optional.ofNullable(regions.get(name));
  }

  /**
   * Used to resolve the region name to its connection or itself if no connection exists.
   *
   * @param region The region to get the true name, with connection if possible.
   *
   * @return The region name if no connection, otherwise the name of the connection.
   */
  @NotNull
  public String resolveRegion(final String region) {
    return sharing.getOrDefault(region, region);
  }

}