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
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

import org.spongepowered.api.util.command.args.GenericArguments;
import org.spongepowered.api.util.command.args.CommandElement;
import org.spongepowered.api.text.Text;

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
	private Server server;
	private MessageSink sink;
	
	/**
	 *Execute on GameStartingServerEvent event
	 *Plugin initialization
	 */
	@Listener
	public void onGameStartingServerEvent(GameStartingServerEvent event)
	{
		plugin = this;
		server = game.getServer();
		sink = server.getBroadcastSink();
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
		/**
		 * HelloWorldSpec initialization
		 */
		CommandSpec helloWorldSpec = CommandSpec.builder()
                .description(Texts.of("Hello World Test Command"))
                .executor(new HelloWorldCommand(this))
                .arguments(GenericArguments.optional(GenericArguments.string(Texts.of("out"))))
                .build();
		
		/**
		 * GetLocationSpec initialization
		 */
		CommandSpec GetLocationSpec = CommandSpec.builder()
                .description(Texts.of("Get Location Command"))
                .executor(new GetLocationCommand(this))
                .build();
		
		/**
		 * GetMotdSpec initialization
		 */
		CommandSpec GetMotdSpec = CommandSpec.builder()
                .description(Texts.of("Get Motd Command"))
                .executor(new GetMotdCommand(this))
                .build();
		
		//HelloWorldCommand register
		game.getCommandDispatcher().register(this, helloWorldSpec, "Hello", "HelloWorld", "Hi");
		//GetLocationCommand register
		game.getCommandDispatcher().register(this, GetLocationSpec, "loc");
		//GetMotdCommand register
		game.getCommandDispatcher().register(this, GetMotdSpec, "MOTD");
	}
	
	/**
	 * Return plugin logger of Logger type
	 */
	public Logger getLogger()
	{
		return logger;
	}
	
	/**
	 * Return server plugin is running on
	 */
	public Server getServer()
	{
		return server;
	}
	
	/**
	 * Return server Broadcast MessageSink
	 */
	public MessageSink getBroadcastSink()
	{
		return sink;
	}
}