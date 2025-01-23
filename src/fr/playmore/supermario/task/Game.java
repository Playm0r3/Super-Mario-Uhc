package fr.playmore.supermario.task;

import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.manager.PlayerManager;

public class Game extends BukkitRunnable{

	private Plugin plugin;
	private int timer;
	
	public Game(Plugin plugin, int time) {
		this.plugin = plugin;
		this.timer = time;
	}
	
	@Override
	public void run() {
		if(PlayerManager.players.size() == 1) {
			cancel();
		}
	}
	
}
