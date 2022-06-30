package net.tnemc.core.transaction;
/*
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

import java.util.UUID;

/**
 * Represents a record of a successful {@link Transaction transaction}. Similar to how in the real
 * world we get receipts for completed transactions, these are the same.
 *
 * @see Transaction
 * @author creatorfromhell
 * @since 0.1.2.0
 */
public class Receipt {

  //Our archival information
  private UUID id;
  private long time;
  private String type;

  private UUID from;
  private UUID to;
  private TransactionSource source;
  private Charge charge;

  //Our active information that may be modified.
  private boolean archive = false;
  private boolean voided = false;

  public Receipt(UUID id, long time, Transaction transaction) {
    this.id = id;
    this.time = time;
    this.type = type;
    this.from = from;
    this.to = to;
    this.charge = charge;
  }

  public UUID getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public UUID getFrom() {
    return from;
  }

  public UUID getTo() {
    return to;
  }

  public Charge getCharge() {
    return charge;
  }

  public boolean isArchive() {
    return archive;
  }

  public void setArchive(boolean archive) {
    this.archive = archive;
  }

  public boolean isVoided() {
    return voided;
  }

  public void setVoided(boolean voided) {
    this.voided = voided;
  }
}