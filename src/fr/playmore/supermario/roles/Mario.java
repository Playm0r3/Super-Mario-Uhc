package fr.playmore.supermario.roles;

import org.bukkit.entity.Player;

public class Mario extends Roles {

	private int mushroom = 0;
	
	public static int playerWithMarioRole = 0;
	public static int maxPlayers = 0;
	
	public Mario(Player player) {
		super(player, "Mario", "4");
	}

	@Override
	public void applyEffect() {
		
	}
	
	public int getMushroom() {
		return mushroom;
	}

}
