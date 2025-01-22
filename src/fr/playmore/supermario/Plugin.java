package fr.playmore.supermario;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	private State state;
	
	@Override
	public void onEnable() {
		setState(State.WAITTING);
		System.out.print("Serveur en marche...");
	}
	
	public boolean isState(State state) {
		return this.state == state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}

}
