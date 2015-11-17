package net.rerenderreality.gui;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;

import org.spongepowered.api.Server;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

import org.spongepowered.api.world.World;

public class GuiController
{	
	private RRRP2 plugin;
	
	public void GuiController(RRRP2 plugin)
	{
		this.plugin = plugin;
	}
}