package fr.playmore.supermario.task;

import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;

public class Finish extends BukkitRunnable{
	
	private Plugin plugin;
	private int timer;
	
	public Finish(Plugin plugin, int timer) {
		this.plugin = plugin;
		this.timer = timer;
	}
	
	@Override
	public void run() {
		if(timer == 0) {
			
			cancel();
		}
	}

}
