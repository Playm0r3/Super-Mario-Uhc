package fr.playmore.supermario.task;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.manager.PlayerManager;

public class Start extends BukkitRunnable{

	private int timer;
	private Plugin plugin;
	
	public Start(Plugin plugin, int time) {
		this.timer = time;
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.setLevel(timer);
		}
		
		if(timer == 10) {
			Bukkit.broadcastMessage(plugin.prefixUhc + " Lancement de la partie dans : §e" + timer + " §7secondes !");
			PlayerManager.PlaySoundEveryone(Sound.SHOOT_ARROW, 1.0f, 1.0f);
		}
		
		if(timer <= 5) {
			Bukkit.broadcastMessage(plugin.prefixUhc + " Lancement de la partie dans : §e" + timer + " §7secondes !");
			PlayerManager.PlaySoundEveryone(Sound.SHOOT_ARROW, 1.0f, 1.0f);
		}
		
		if(timer <= 0) {
			
			Game game = new Game(plugin);
			game.runTaskTimer(plugin, 0, 20);
			plugin.setState(State.PLAYING);
			cancel();
		}
		
		timer --;
	}
	
}
