package fr.playmore.supermario.roles;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.playmore.supermario.Plugin;

public abstract class Roles implements Listener{
	
	public Plugin plugin;
	
	public static ArrayList<Roles> roles = new ArrayList<Roles>();
	public static ArrayList<String> rolesList = new ArrayList<String>();
	
	private String name;
	private String color;
	protected Player player;
	
	public Roles(Player player, String roleName, String color, Plugin plugin) {
		this.player = player;
		this.name = roleName;
		this.color = color;
		this.plugin = plugin;
		
	}
	
	public abstract void applyEffect();
	
	public String getName() {
		return name;
	}
	
	public Player getPlayer() {
		return player;
	}

	public String getColor() {
		return color;
	}
	
}
