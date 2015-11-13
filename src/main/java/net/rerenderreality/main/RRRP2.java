package net.rerenderreality.main;

import com.google.inject.Inject;

import net.rerenderreality.command.*;

import org.slf4j.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

@Plugin(id = "net.rerenderreality", name = "RRRP2", version = "0.1-ALPHA")
public class RRRP2
{
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
	 *Plugin initialization
	 */
	@Listener
	public void onGameStartingServerEvent(GameStartingServerEvent event)
	{
		plugin = this;
<<<<<<< HEAD
		logger.info(name + " v" + version + " has successfully been initialized.");
		buildAndRegisterCommands();
=======
		getLogger().info(name + " v" + version + " has successfully been initialized.");
		CommandRegistry registry = new CommandRegistry();

		game.getCommandDispatcher().register(plugin, myCommandSpec, "message", "msg", "m");
		game.getCommandDispatcher().register(plugin, registry.getCommandSpec(), registry.getAliases("Hello"));
>>>>>>> 011df49f90c2cf02c9981c8feeb2ae2f3849acd8
	}

	/**
	 * Execute on GameStoppingServerEvent event
	 * Plugin Uninitialization
	 */
	@Listener
	public void onGameStoppingServerEvent(GameStoppingServerEvent event)
	{
		getLogger().info(name + " v" + version + " has successfully been unitialized.");
	}
	
	/**
	 * Build and register all plugin commands
	 * To be executed at plugin initialization
	 */
	private void buildAndRegisterCommands()
	{
		//HelloWorldCommand
		CommandSpec HelloWorldCommand = CommandSpec.builder()
				.description(Texts.of("Hello World Command"))
				.executor(new HelloWorldCommand(this))
				.build();
		game.getCommandDispatcher().register(this, HelloWorldCommand, "Hello", "HelloWorld", "Hi");
		//TPSCommand
		CommandSpec GetLocationCommand = CommandSpec.builder()
				.description(Texts.of("Get Location Command"))
				.executor(new GetLocationCommand(this))
				.build();
		game.getCommandDispatcher().register(this, GetLocationCommand, "loc");
	}
	
	/**
	 * Return plugin logger of Logger type
	 */
	public Logger getLogger()
	{
		return logger;
	}
}
