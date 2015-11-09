package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class CommandRegistry {

	CommandSpec myCommandSpec = CommandSpec.builder()
			.description(Texts.of("Hello World Command"))
			.permission("myplugin.command.helloworld")
			.executor(new CommandExecutors()).build();

	public void registerCommands() {
		game.getCommandDispatcher().register(RRRP2.plugin, myCommandSpec,
				"helloworld", "hello", "test");
	}

}
