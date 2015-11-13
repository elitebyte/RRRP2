package net.rerenderreality.command;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.source.CommandBlockSource;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;
import org.spongepowered.api.text.Texts;

public class CommandExecutors implements CommandExecutor {
	
	CommandHandler commandHandler = new CommandHandler();

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{	
		
		src.sendMessage(Texts.of("HELLO WORLD"));
				/**if (src instanceof Player) {
					Player p = (Player) src;
					commandHandler.commandHandlerPlayer(p, args);
				}
				
				else if (src instanceof ConsoleSource) {
					commandHandler.commandHandlerConsole(src, args);
				}
				
				else if (src instanceof CommandBlockSource) {
					commandHandler.commandHandlerCmdBlock(src, args);
				}*/
		return CommandResult.success();
	}
		
}