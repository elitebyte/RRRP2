package net.rerenderreality.command;

import com.google.inject.Inject;

import net.rerenderreality.main.RRRP2;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;
import org.spongepowered.api.util.command.dispatcher.*;
import org.spongepowered.api.*;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.command.*;

public class CommandRegistry
{
	public CommandRegistry() {}
	
	public CommandSpec getSpec()
	{
		CommandSpec myCommandSpec = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.executor(new CommandExecutors()).build();
		
		return myCommandSpec;
	}	
}
