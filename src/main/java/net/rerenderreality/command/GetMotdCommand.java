package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.Server;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class GetMotdCommand implements CommandExecutor
{	
	private Logger logger;
	private RRRP2 plugin;
	private Server server;
	
	public GetMotdCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
	}
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{	
		//arguments = args.split(" ");
		
		if (src instanceof Player)
		{
			Player p = (Player) src;
			p.sendMessage(Texts.of(server.getMotd()));
			return CommandResult.success();
		}
		return CommandResult.success();
	}
}