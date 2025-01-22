package fr.playmore.supermario;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.playmore.supermario.listeners.PluginListener;
import fr.playmore.supermario.manager.WorldManager;

public class Plugin extends JavaPlugin {
	
	private State state;
	
	public String prefixPlugin = "§7[§1M§2A§eR§4I§2O §bUHC§7]";
	public String prefixUhc = "§7[§6UHC§7]";
	
	public World overworld = Bukkit.getWorld("world");
	public World nether = Bukkit.getWorld("world_nether");
	public World end = Bukkit.getWorld("world_the_end");
	
	@Override
	public void onEnable() {
		setState(State.WAITTING);
		System.out.print("Serveur en marche...");
		
		WorldManager.createSpawn(this.end, 1010, 1010, 990, 990);
		
		getServer().getPluginManager().registerEvents(new PluginListener(this), this);
		
	}
	
	public boolean isState(State state) {
		return this.state == state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}

}
