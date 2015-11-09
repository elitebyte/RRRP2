package net.rerenderreality.command;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class CommandExecutors implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args)
			throws CommandException {
		if (src instanceof Player) {
			commandHandlerPlayer(src, args);
		} else if (src instanceof ConsoleCommandSender) {

		}
		return CommandResult.success();
	}

}
