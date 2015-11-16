package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class GetLocationCommand implements CommandExecutor
{	
	private final Logger logger;
	private final RRRP2 plugin;
	private final Server server;
	private String[] arguments;
	
	public GetLocationCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
	}
	
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
		if (src instanceof Player)
		{
			Player p = (Player) src;
			p.sendMessage(Texts.of("Current location (X: " + p.getLocation().getBlockX() + " Y: " + p.getLocation().getBlockY() + " Z: " + p.getLocation().getBlockZ() + ")"));
		}
		return CommandResult.success();
	}	
}