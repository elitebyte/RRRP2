package net.rerenderreality.main;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "net.rerenderreality", name = "RRRP2", version = "0.1-ALPHA")
public class RRRP2 {

	public final String id = "net.rerenderreality";
	public final String version = "0.1-ALPHA";
	public final String name = "RRRP2";

	public RRRP2 plugin = this;

	@Inject
	private Logger logger;

	@Listener
	public void onServerStart(GameStartedServerEvent event) {
		getLogger().info(
				name + " v" + version + " has successfully been initialized!");
	}

	@Listener
	public void onServerStop(GameStartedServerEvent event) {
		getLogger().info(
				name + " v" + version + " has successfully been unitialized!");
	}

	/*
	 * Logger Methods : getLogger(), setLogger()
	 */
	public Logger getLogger() {
		return logger;
	}

	@Inject
	private void setLogger(Logger logger) {
		this.logger = logger;
	}
}