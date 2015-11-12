package net.rerenderreality.main;

import com.google.inject.Inject;

import org.slf4j.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;


//Pulled from CommandRegistry.java
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;
import org.spongepowered.api.util.command.dispatcher.*;
import org.spongepowered.api.*;
import com.google.inject.Inject;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.command.*;

@Plugin(id = "net.rerenderreality", name = "RRRP2", version = "0.1-ALPHA")
public class RRRP2 {

	public final String id = "net.rerenderreality";
	public final String version = "0.1-ALPHA";
	public final String name = "RRRP2";

	@Inject
	public Game game;
	public RRRP2 plugin;

	@Inject
	private Logger logger;
	
	/**
	 *Execute on GameStartingServerEvent event
	 */
	@Listener
	public void onGameStartingServerEvent(GameStartingServerEvent event)
	{
		plugin = this;
		getLogger().info(name + " v" + version + " has successfully been initialized!");
		
		//Pulled from CommandRegistry.java
		CommandSpec myCommandSpec = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.executor(new CommandExecutors()).build();

		String[] aliases = {"Hello", "HelloWorld", "Test"};
		game.getCommandDispatcher().register(plugin, myCommandSpec, aliases);
	}

	/**
	 * Execute on GameStoppingServerEvent event
	 */
	@Listener
	public void onGameStoppingServerEvent(GameStoppingServerEvent event)
	{
		getLogger().info(name + " v" + version + " has successfully been unitialized!");
	}

	/**
	 * Return plugin logger of Logger type
	 */
	public Logger getLogger()
	{
		return logger;
	}
}