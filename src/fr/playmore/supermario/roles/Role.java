package fr.playmore.supermario.roles;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import fr.playmore.supermario.utils.Color;

public abstract class Role{
	
	public static List<Role> roleList = new ArrayList<Role>();

	public Player player;
	public String name;
	public Color color;
	
	public Role(String name, Color color)
	{
		this.name = name;
		this.color = color;
	}
	
	public abstract void ApplyEffect();	
}
