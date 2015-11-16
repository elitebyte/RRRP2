package net.rerenderreality.command;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.source.CommandBlockSource;
import org.spongepowered.api.util.command.source.ConsoleSource;

public class BaseCommand {

	public String name;
	public String description;
	public String permission;
	public String[] aliases;
	
	public CommandSource src;
	
	/*
	 *   Returns a String with the value
	 * "Player" , "Console" , "CommandBlock" or ""
	 */
	public String getSourceType() {
		
		if (src instanceof Player) {
			return "Player";
		}
		else if (src instanceof ConsoleSource) {
			return "Console";
		}
		else if (src instanceof CommandBlockSource) {
			return "CommandBlock";
		}
		return "";
	}
	
	/*
	 * Retrieves the permission string
	 */
	public String getPermission() {
		return permission;
	}
	
	/*
	 * Returns the Command Source
	 */
	public CommandSource getCommandSource() {
		return src;
	}
	
	/*
	 * Retrieves the name of the command
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Retrieves the description of the command
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Returns the aliases 
	 */
	public String[] getAliases() {
		return aliases;
	}
	
	public boolean isPlayer() {
		if (src instanceof Player)
			return true;
		else
			return false;
	}
	
	public boolean isConsole() {
		if (src instanceof Player)
			return true;
		else
			return false;
	}
	
	public boolean isCommandBlock() {
		if (src instanceof Player)
			return true;
		else
			return false;
	}
	
}
