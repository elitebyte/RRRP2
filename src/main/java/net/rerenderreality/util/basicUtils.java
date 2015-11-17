package net.rerenderreality.util;

import net.minecraftforge.server.command.ForgeCommand;
import net.rerenderreality.main.RRRP2;

import org.spongepowered.api.world.World;

public class basicUtils
{	
	RRRP2 plugin;
	
	public basicUtils(RRRP2 plugin) {
		this.plugin = plugin;
	}
	
	public double getTps(World world)
	{
        double worldTickTime = ForgeCommand.mean(plugin.getServer().worldTickTimes.get(dim)) * 1.0E-6D;
        double worldTPS = Math.min(1000.0/worldTickTime, 20);
		return 0.0;
	}
	
	public double getMean(int... values)
	{
		int amt = 0;
		for (int value : values) {
			amt += value;
		}
		return amt/values.length;
	}
}