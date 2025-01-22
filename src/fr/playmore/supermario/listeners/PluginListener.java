package fr.playmore.supermario.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
			event.setJoinMessage("§2§l" + player.getName() + "§r§a a rejoint la partie.");
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		if(plugin.isState(State.WAITTING)) {
			PlayerManager.PlayerQuitWhenWaitting(player);
			event.setQuitMessage("§2§l" +player.getName() + "§r§a a rejoint la partie.");
		}
	}
	
	@EventHandler
	public void destroyBlock(BlockBreakEvent event) {
		
		if(plugin.isState(State.WAITTING)) {
			event.setCancelled(true);
		}
		
	}

}
