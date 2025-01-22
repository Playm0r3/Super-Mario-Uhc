package fr.playmore.supermario;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.playmore.supermario.listeners.PluginListener;

public class Plugin extends JavaPlugin {
	
	private State state;
	
	public World overworld = Bukkit.getWorld("world");
	public World nether = Bukkit.getWorld("world_nether");
	public World end = Bukkit.getWorld("world_the_end");
	
	@Override
	public void onEnable() {
		setState(State.WAITTING);
		System.out.print("Serveur en marche...");
		
		getServer().getPluginManager().registerEvents(new PluginListener(this), this);
		
	}
	
	public boolean isState(State state) {
		return this.state == state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}

}
