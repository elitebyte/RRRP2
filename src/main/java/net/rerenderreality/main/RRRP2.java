package net.rerenderreality.main;

import net.rerenderreality.command.BaseCommand;
import net.rerenderreality.command.CommandExecutors;
import net.rerenderreality.command.GetLocationCommand;
import net.rerenderreality.command.GetMotdCommand;
import net.rerenderreality.command.HelloWorldCommand;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.command.args.GenericArguments;
import org.spongepowered.api.util.command.spec.CommandExecutor;
import org.spongepowered.api.util.command.spec.CommandSpec;

import com.google.inject.Inject;

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
	private Server server;
	private MessageSink sink;

	/**
	 * Execute on GameStartingServerEvent event Plugin initialization
	 */
	@Listener
	public void onGameStartingServerEvent(GameStartingServerEvent event) {
		plugin = this;

		getLogger().info(name + " v" + version + " has successfully been initialized!");
		server = game.getServer();
		sink = server.getBroadcastSink();
		logger.info(name + " v" + version
				+ " has successfully been initialized.");
		buildAndRegisterCommands();
	}

	/**
	 * Execute on GameStoppingServerEvent event Plugin Uninitialization
	 */
	@Listener
	public void onGameStoppingServerEvent(GameStoppingServerEvent event) {
		logger.info(name + " v" + version
				+ " has successfully been unitialized.");
	}

	/**
	 * Build and register all plugin commands To be executed at plugin
	 * initialization
	 */
	private void buildAndRegisterCommands() {
		/**
		 * HelloWorldSpec initialization
		 */
		CommandSpec helloWorldSpec = CommandSpec
				.builder()
				.description(Texts.of("Hello World Test Command"))
				.executor(new HelloWorldCommand(this))
				.arguments(
						GenericArguments.optional(GenericArguments.string(Texts
								.of("out")))).build();

		/**
		 * GetLocationSpec initialization
		 */
		CommandSpec getLocationSpec = CommandSpec.builder()
				.description(Texts.of("Get Location Command"))
				.executor(new GetLocationCommand(this)).build();

		
		/**
		 * GetMotdSpec initialization
		 */
		CommandSpec getMotdSpec = CommandSpec.builder()
				.description(Texts.of("Get Motd Command"))
				.executor(new GetMotdCommand(this)).build();

		/**
		 * GetTpsSpec initialization CommandSpec getTpsSpec =
		 * CommandSpec.builder() .description(Texts.of("Get Tps Command"))
		 * .executor(new GetTpsCommand(this)) .build();
		 */
		
		// HelloWorldCommand register
		game.getCommandDispatcher().register(this, helloWorldSpec, "Hello", "HelloWorld", "Hi");
		
		// GetLocationCommand register
		game.getCommandDispatcher().register(this, getLocationSpec, "Loc");
		
		// GetMotdCommand register
		game.getCommandDispatcher().register(this, getMotdSpec, "MOTD");
		
		// GetTpsCommand register
		 //game.getCommandDispatcher().register(this, getTpsSpec, "Tps","Ticks");
	}
	
	public void commandSpecFactory() {
		int numofcmds = 3;
		CommandSpec[] commandSpecs = new CommandSpec[numofcmds];
		String[][] aliases = new String[numofcmds][numofcmds];
		
		BaseCommand bc = new BaseCommand();
		
		aliases[0] = stringFormatter("Hello", "HelloWorld");
		commandSpecs[0] = CommandSpec.builder().description(Texts.of("Hi")).executor(new CommandExecutors(this)).build();
		
		
		
		for (int i = 0 ; i <= commandSpecs.length ; i++) {
			game.getCommandDispatcher().register(this, commandSpecs[i], aliases[i]);
		}
	}
	
	public void commandFactory(String name, String[] aliases, String permissions, String description, CommandExecutor executor) {
		BaseCommand bc = new BaseCommand();
		bc.name = name;
		bc.aliases = aliases;
		bc.description = description;
		
		CommandSpec commandSpec = CommandSpec.builder().description(Texts.of(description)).executor(executor).build();
		game.getCommandDispatcher().register(this, commandSpec, aliases);
	}
	
	public String[] stringFormatter(String... strings) {
		return strings;
	}

	/**
	 * Return plugin logger of Logger type
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * Return server plugin is running on
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * Return server Broadcast MessageSink
	 */
	public MessageSink getBroadcastSink() {
		return sink;
	}
}