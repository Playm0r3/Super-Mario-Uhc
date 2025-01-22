package fr.playmore.supermario.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.manager.PlayerManager;

public class PluginListener implements Listener {
	
	private Plugin plugin;

	public PluginListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(plugin.isState(State.WAITTING)) {
			PlayerManager.PlayerJoinWhenWaitting(player, plugin.end);
		}
	}

}
