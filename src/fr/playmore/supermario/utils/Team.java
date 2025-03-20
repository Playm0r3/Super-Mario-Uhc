package fr.playmore.supermario.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Team {

	private List<Player> players = new ArrayList<Player>();
	private static List<Team> teams = new ArrayList<Team>();
	
	public void AddPlayer(Player player)
	{
		players.add(player);
	}
	
	public boolean HasPlayer(Player player)
	{
		if(players.contains(player))
			return true;
		
		return false;
	}
	
	public void RemovePlayer(Player player)
	{
		if(HasPlayer(player))
		{
			players.remove(player);
			return;
		}
		
		System.out.println("Player is not in this Team");
	}
	
	public static Team GetTeam(Player player)
	{
		for(Team t : teams)
		{
			if(t.HasPlayer(player))
				return t;
		}
		
		System.out.println("Player : " + player.getName() + " is not in exist Team");
		return null;
	}
}
