package fr.playmore.supermario.roles;

import org.bukkit.entity.Player;

public class Joueur{
	
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
}
