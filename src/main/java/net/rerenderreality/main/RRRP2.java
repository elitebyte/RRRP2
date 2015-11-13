package net.rerenderreality.main;

import com.google.inject.Inject;

import net.rerenderreality.command.CommandRegistry;

import org.slf4j.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;

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
	 *Plugin initialization and commands registration
	 */
	@Listener
	public void onGameStartingServerEvent(GameStartingServerEvent event)
	{
		plugin = this;
		getLogger().info(name + " v" + version + " has successfully been initialized!");
		CommandRegistry r = new CommandRegistry();
		game.getCommandDispatcher().register(plugin, r.getCommandSpec(), r.getAliases("Hello"));
	}

	/**
	 * Execute on GameStoppingServerEvent event
	 * Plugin Uninitialization
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