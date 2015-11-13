package net.rerenderreality.main;

import com.google.inject.Inject;

import net.rerenderreality.command.*;

import org.slf4j.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Server;
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
	public Server server;

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
		server = game.getServer();
		logger.info(name + " v" + version + " has successfully been initialized.");
		buildAndRegisterCommands();
	}

	/**
	 * Execute on GameStoppingServerEvent event
	 * Plugin Uninitialization
	 */
	@Listener
	public void onGameStoppingServerEvent(GameStoppingServerEvent event)
	{
		logger.info(name + " v" + version + " has successfully been unitialized.");
	}
	
	/**
	 * Build and register all plugin commands
	 * To be executed at plugin initialization
	 */
	private void buildAndRegisterCommands()
	{
		//HelloWorldCommand
		game.getCommandDispatcher().register(this, new HelloWorldCommand(this), "Hello", "HelloWorld", "Hi");
		//GetLocationCommand
		game.getCommandDispatcher().register(this, new GetLocationCommand(this), "loc");
		//GetMotdCommand
		game.getCommandDispatcher().register(this, new GetMotdCommand(this), "MOTD");
	}
	
	/**
	 * Return plugin logger of Logger type
	 */
	public Logger getLogger()
	{
		return logger;
	}
	
	public Server getServer()
	{
		return server;
	}
}
