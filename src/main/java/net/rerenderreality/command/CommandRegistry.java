package net.rerenderreality.command;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class CommandRegistry {
	public CommandRegistry() {
	}

	public CommandSpec getCommandSpec() {
		CommandSpec myCommandSpec = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.executor(new CommandExecutors()).build();

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