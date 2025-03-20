package fr.playmore.supermario;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import fr.playmore.supermario.commands.OperatorExecutor;
import fr.playmore.supermario.commands.PlayerExecutor;
import fr.playmore.supermario.listeners.PluginListener;
import fr.playmore.supermario.manager.WorldManager;

public class Plugin extends JavaPlugin {
	
	private State state;
	
	public String prefixPlugin = "§7[§1M§2A§eR§4I§2O §bUHC§7]";
	public String prefixUhc = "§7[§6UHC§7]";
	
	public World overworld;
	public World nether;
	public World end;
	
	public boolean team = false;
	
	@Override
	public void onEnable() {
		setState(State.WAITTING);
		System.out.print("Serveur en marche...");
		
		LoadCommand();
		WorldManager.LoadWorld(this);
		WorldManager.createSpawn(this.end, 1010, 1010, 990, 990);
		
		getServer().getPluginManager().registerEvents(new PluginListener(this), this);
		
	}
	
	public boolean isState(State state) {
		return this.state == state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}
	
	public State getState() {
		return state;
	}

	public void LoadCommand() {
		
		OperatorExecutor operator = new OperatorExecutor(this);
		PlayerExecutor player = new PlayerExecutor(this);
		
		getCommand("start").setExecutor(operator);
		getCommand("state").setExecutor(operator);
		getCommand("add").setExecutor(operator);
		getCommand("remove").setExecutor(operator);
		getCommand("mu").setExecutor(player);
		
	}
	
}
