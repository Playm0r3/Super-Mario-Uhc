package fr.playmore.supermario.manager;

import java.util.ArrayList;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerManager {
	
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void PlayerJoinWhenWaitting(Player player, World world) {
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setGameMode(GameMode.SURVIVAL);
		player.setLevel(0);
		player.getInventory().clear();
		player.teleport(new Location(world, 1000, 200, 1000));
		players.add(player);
	}
	
	public static void PlayerQuitWhenWaitting(Player player) {
		players.remove(player);
	}
	
}
