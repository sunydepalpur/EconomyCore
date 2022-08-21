package net.tnemc.core.command;
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

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;

/**
 * TransactionCommand
 *
 * @author creatorfromhell
 * @since 0.1.2.0
 */
@CommandAlias("transaction|trans|receipt")
public class TransactionCommand<C> extends BaseCommand {

  @Subcommand("away|gone|afk|afg")
  @Syntax("%Transaction.Away.Arguments")
  @Description("%Transaction.Away.Description")
  @CommandPermission("tne.transaction.away")
  public void away(C sender, String[] args) {

  }

  @Default
  @Subcommand("history|list|hist|archive")
  @Syntax("%Transaction.History.Arguments")
  @Description("%Transaction.History.Description")
  @CommandPermission("tne.transaction.history")
  public void history(C sender, String[] args) {

  }

  @Subcommand("info|i|about|brief")
  @Syntax("%Transaction.Info.Arguments")
  @Description("%Transaction.Info.Description")
  @CommandPermission("tne.info.history")
  public void info(C sender, String[] args) {

  }

  @Subcommand("void|retract|undo")
  @Syntax("%Transaction.Void.Arguments")
  @Description("%Transaction.Void.Description")
  @CommandPermission("tne.void.history")
  public void voidT(C sender, String[] args) {

  }
}