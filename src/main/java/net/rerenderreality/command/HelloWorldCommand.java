package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.Server;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;

/**
 * Example command class for reference on further command class creation
 */
public class HelloWorldCommand implements CommandExecutor
{	
	private Logger logger;
	private RRRP2 plugin;
	private Server server;
	private MessageSink sink;
	
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
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{	
		if (src instanceof Player)
		{
			if (args.hasAny("out"))
			{
				sink.sendMessage(Texts.of("HELLO SERVER"));
			}
			else
			{
				Player p = (Player) src;
				p.sendMessage(Texts.of("HELLO WORLD"));
			}
			return CommandResult.success();
		}
		return CommandResult.success();
	}
}