package net.tnemc.sponge.impl;
/*
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

import net.tnemc.core.compatibility.PlayerProvider;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.UUID;

/**
 * The Sponge implementation of the {@link PlayerProvider}.
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public class SpongePlayerProvider implements PlayerProvider {

  private ServerPlayer player;

  public SpongePlayerProvider(ServerPlayer player) {
    this.player = player;
  }

  /**
   * Used to get the {@link UUID} of this player.
   *
   * @return The {@link UUID} of this player.
   */
  @Override
  public UUID getUUID() {
    return player.uniqueId();
  }

  /**
   * Used to get the name of this player.
   *
   * @return The name of this player.
   */
  @Override
  public String getName() {
    return player.name();
  }

  /**
   * Used to get the name of the world this player is in.
   *
   * @return The name of the world.
   */
  @Override
  public String getWorld() {
    return player.world().key().asString();
  }

  /**
   * Used to get the amount of experience this player has.
   *
   * @return The amount of levels this player has.
   */
  @Override
  public int getExp() {
    return player.experience().get();
  }

  /**
   * Used to set the amount of experience this player has.
   *
   * @param exp The amount of experience to set for this player.
   */
  @Override
  public void setExp(int exp) {
    player.offer(Keys.EXPERIENCE, exp);
  }

  /**
   * Used to get the amount of experience levels this player has.
   *
   * @return The amount of experience levels this player has.
   */
  @Override
  public int getExpLevel() {
    return player.experienceLevel().get();
  }

  /**
   * Used to set the amount of experience levels this player has.
   *
   * @param level The amount of experience levels to set for this player.
   */
  @Override
  public void setExpLevel(int level) {
    player.offer(Keys.EXPERIENCE_LEVEL, level);
  }

  /**
   * Used to get an inventory object.
   *
   * @param ender True if the ender chest object should be returned, otherwise false.
   *
   * @return The inventory object.
   */
  @Override
  public Object getInventory(boolean ender) {
    if(ender) {
      return player.enderChestInventory();
    }
    return player.inventory();
  }

  /**
   * Used to determine if this player has the specified permission node.
   *
   * @param permission The node to check for.
   *
   * @return True if the player has the permission, otherwise false.
   */
  @Override
  public boolean hasPermission(String permission) {
    return player.hasPermission(permission);
  }
}