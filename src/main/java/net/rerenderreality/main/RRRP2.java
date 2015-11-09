package net.rerenderreality.main;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "net.rerenderreality.rrrp2", name = "RRRP2", version = "0.1-ALPHA")
public class RRRP2 {

	private Logger logger;

	@Listener
	public void onServerStart(GameStartedServerEvent event) {

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