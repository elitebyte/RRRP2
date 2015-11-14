package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.Server;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

public class GetMotdCommand implements CommandCallable
{	
	private Logger logger;
	private RRRP2 plugin;
	private Server server;
	private String[] args;
	
	public GetMotdCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
		server = plugin.getServer();
	}
	
	/**
	 * To be executed on command use
	 */
	@Override
	public CommandResult process(CommandSource src, String args) throws CommandException
	{	
		this.args = args.split(" ");
		
		if (src instanceof Player)
		{
			Player p = (Player) src;
			p.sendMessage(Texts.of(server.getMotd()));
			return CommandResult.success();
		}
		return CommandResult.success();
	}

	/**
	 * Command detail variables
	 */
	private final Text usage = Texts.builder("Usage: /MOTD").color(TextColors.YELLOW).build();
	private final Text help = Texts.builder("Help: /MOTD").color(TextColors.YELLOW).build();
	private final Text description = Texts.builder("Get MOTD Command").color(TextColors.YELLOW).build();
	private List<String> suggestions = new ArrayList<String>();
	private String permission = "";
	
	/**
	 * Command details overriding CommandCallable defaults
	 */
	@Override
	public Text getUsage(CommandSource sender) { return usage; }
	@Override
	public Optional<Text> getHelp(CommandSource sender) { return Optional.of(help); }
	@Override
	public Optional<Text> getShortDescription(CommandSource sender) { return Optional.of(description); }
	@Override
	public List<String> getSuggestions(CommandSource sender, String args) throws CommandException { return suggestions; }
	@Override
	public boolean testPermission(CommandSource sender) { return permission.equals("") ? true : sender.hasPermission(permission); }
}
