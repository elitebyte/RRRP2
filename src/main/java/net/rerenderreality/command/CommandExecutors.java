package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.source.CommandBlockSource;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class CommandExecutors implements CommandExecutor {

	CommandHandler commandHandler = new CommandHandler();

	private final Logger logger;
	private final RRRP2 plugin;
	private final Server server;
	private String[] arguments;

	public CommandExecutors (RRRP2 plugin) {
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
	}


	public CommandResult execute(CommandSource src, CommandContext args)
			throws CommandException {
		if (src instanceof Player) {
			commandHandler.commandHandlerPlayer(src, args);
		} else if (src instanceof ConsoleSource) {
			commandHandler.commandHandlerConsole(src, args);
		} else if (src instanceof CommandBlockSource) {
			commandHandler.commandHandlerCmdBlock(src, args);
		}
		return CommandResult.success();
	}
}