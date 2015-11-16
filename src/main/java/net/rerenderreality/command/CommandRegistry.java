package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class CommandRegistry {
	
	private final RRRP2 plugin;
	
	public CommandRegistry(RRRP2 plugin) {
		this.plugin = plugin;
	}

	public CommandSpec getCommandSpec() {
		CommandSpec myCommandSpec = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.executor(new CommandExecutors(plugin)).build();

		return myCommandSpec;
	}

	public String[] getAliases(String command) {
		if (command == "Hello") {
			String[] aliases = { "Hello", "HelloWorld" };
			return aliases;
		}
		return null;
	}
}