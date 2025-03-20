package fr.playmore.supermario.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.manager.PlayerManager;
import fr.playmore.supermario.math.Vector3;
import fr.playmore.supermario.roles.Joueur;
import fr.playmore.supermario.roles.Mario;
import fr.playmore.supermario.title.Title;
import fr.playmore.supermario.utils.CustomInventory;

public class PluginListener implements Listener {
	
	private Plugin plugin;
	private Title title = new Title();

	public PluginListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(plugin.isState(State.WAITTING)) {
			PlayerManager.PlayerJoinWhenWaitting(player, plugin.end);
			title.sendTitle(player, 20, 80, 60, "§fSuper §1M§2A§eR§4I§2O", "§bUHC §7: by Playm0r3");
			event.setJoinMessage("§2§l" + player.getName() + "§r§a a rejoint la partie.");
			player.sendMessage(plugin.prefixPlugin + " version : §b" + plugin.getDescription().getVersion());
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
	
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		
		
		if(event.getEntity() instanceof Player) {
			Player victim = (Player) event.getEntity();
			
			if(event.getDamager() instanceof Player) {
				Player damager = (Player) event.getEntity();
				
				if(!plugin.isState(State.PVP)) {
					event.setCancelled(true);
					return;
				}
				
				if(victim.getHealth() <= event.getDamage()) {
					PlayerManager.PlaySoundEveryone(victim.getLocation(), Sound.AMBIENCE_THUNDER, 10.f, 1.f);
					Bukkit.broadcastMessage("§4" + damager.getName() + " §7a tué §c" + victim.getName());
					return;
				}
				
			}
			
			if(event.getDamager() instanceof Arrow) {
				Arrow arrow = (Arrow) event.getDamager();
				
				if(!plugin.isState(State.WAITTING)) {
					event.setCancelled(false);
					return;
				}
				
				if(arrow.getShooter() instanceof Player && victim.getHealth() <= event.getDamage()) {
					
					Player shooter = (Player) arrow.getShooter();
					PlayerManager.PlaySoundEveryone(victim.getLocation(), Sound.AMBIENCE_THUNDER, 10.f, 1.f);
					Bukkit.broadcastMessage("§4" + shooter.getName() + " §7a tué §c" + victim.getName() 
							+ " ("+Vector3.getDistancePlayers(shooter, victim)+"mètres)");
					return;
				}
			}
			
		}
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void onInteract(InventoryClickEvent event)
	{
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))
		{
			if(event.getInventory().getName().equals("Select Class"))
			{
				if(event.getCurrentItem().equals(CustomInventory.GetMarioItem()))
				{
					Joueur j = new Joueur((Player)event.getWhoClicked(), new Mario());
					Joueur.inGame.put((Player) event.getWhoClicked(), j);
				}
			}
		}
	}

}
