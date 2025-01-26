package fr.playmore.supermario.roles;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import fr.playmore.supermario.Plugin;

public class Peach extends Roles{

	private int gApple = 0;
	
	public Peach(Player player, String roleName, String color, Plugin plugin) {
		super(player, roleName, color, plugin);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void applyEffect() {
		if(gApple >= 10) {
			gApple = 0;
			ItemStack it = new ItemStack(Material.GOLDEN_APPLE);
			it.setData(new MaterialData(Material.GOLDEN_APPLE, (byte) 1));
		}
	}
	
	@EventHandler
	public void eat(PlayerItemConsumeEvent event) {
		if(event.getPlayer() == player) {
			if(event.getItem().getType().equals(Material.GOLDEN_APPLE)) {
				gApple += 1;
			}
		}
	}
}
