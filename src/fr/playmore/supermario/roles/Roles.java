package fr.playmore.supermario.roles;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public abstract class Roles {
	
	public static ArrayList<Roles> roles = new ArrayList<Roles>();
	
	private String name;
	private String color;
	private Player player;
	
	public Roles(Player player, String roleName, String color) {
		this.player = player;
		this.name = roleName;
		this.color = color;
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
