package fr.playmore.supermario.task;

import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;

public class Start extends BukkitRunnable{

	private int timer;
	private Plugin plugin;
	
	public Start(Plugin plugin, int time) {
		this.timer = time;
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		if(timer == 0) {
			cancel();
		}
	}
	
}
