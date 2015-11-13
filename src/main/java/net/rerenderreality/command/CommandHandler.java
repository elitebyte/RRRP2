package net.rerenderreality.command;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.CommandSource;

public class CommandHandler {

	public void commandHandlerPlayer(CommandSource src, CommandContext args)
	{
		Player p = (Player) src;
		p.sendMessage(Texts.of("HELLO WORLD"));
	}
	
	public void commandHandlerConsole(CommandSource src, CommandContext args)
	{

	}

	public void commandHandlerCmdBlock(CommandSource src, CommandContext args)
	{

	}
}