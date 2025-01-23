package fr.playmore.supermario.task;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.manager.PlayerManager;

public class Game extends BukkitRunnable{

	private Plugin plugin;
	private long timer;
	
	public Game(Plugin plugin) {
		this.plugin = plugin;
		this.timer = 0;
	}
	
	@Override
	public void run() {
		if(PlayerManager.players.size() == 1 && (plugin.isState(State.PLAYING) || plugin.isState(State.PVP))) {
			plugin.setState(State.FINISH);
			
			Finish finish = new Finish(plugin, PlayerManager.players.get(0));
			finish.runTaskTimer(plugin, 0, 10);
			cancel();
		}
		
		if(timer >= 1200) {
			plugin.setState(State.PVP);
			Bukkit.broadcastMessage(plugin.prefixUhc + " Activation du §4Pvp §7!");
		}
		
		timer ++;
	}
	
}
