package net.rerenderreality.command;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class CommandRegistry {

		CommandSpec myCommandSpec = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.permission("myplugin.command.helloworld")
				.executor(new CommandExecutors()).build();

		game.getCommandDispatcher().register(plugin, myCommandSpec,
				"helloworld", "hello", "test");

}
