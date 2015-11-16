package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

/**
 * Example command class for reference on further command class creation
 */
public class HelloWorldCommand implements CommandExecutor
{	
	private final Logger logger;
	private final RRRP2 plugin;
	private final Server server;
	private final MessageSink sink;
	
	/**
	 * Command class constructor with variable initialization
	 */
	public HelloWorldCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
		sink = plugin.getBroadcastSink();
	}
	
	/**
	 * To be executed on command use
	 */
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{	
		if (src instanceof Player)
		{
			if (args.hasAny("out"))
			{
				if (args.<String>getOne("out").get().equals("server"))
				{
					sink.sendMessage(Texts.of("HELLO SERVER"));
					return CommandResult.success();
				}
			}
			else
			{
				src.sendMessage(Texts.of("HELLO WORLD"));
				return CommandResult.success();
			}
		}
		return CommandResult.empty();
	}
}