package fr.playmore.supermario.roles;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class Joueur{
	
	public static Map<Player, Joueur> inGame = new HashMap<Player, Joueur>();
	
	public Player player;
	public Role role;
	
	public Joueur(Player player, Role role)
	{
		this.player = player;
		if(role.player == null)
			role.player = player;
	}

	public void ApplyRoleEffect()
	{
		role.ApplyEffect();
	}
	
	public static Joueur GetJoueur(Player player)
	{
		return inGame.get(player);
	}
}
