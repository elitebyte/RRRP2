package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class GetMotdCommand implements CommandExecutor
{	
	private final Logger logger;
	private final RRRP2 plugin;
	private final Server server;
	
	public GetMotdCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
	}
	
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{	
		src.sendMessage(Texts.of(Texts.of("Today's Message of the Day is: ").toText(), server.getMotd().toText()));
		return CommandResult.success();
	}
}