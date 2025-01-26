package fr.playmore.supermario.roles;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.playmore.supermario.Plugin;

public class Luigi extends Roles {
	
	private boolean lowHealthBonus = false;
	
	private PotionEffect speed1 = new PotionEffect(PotionEffectType.SPEED, 2, 0);
	private PotionEffect speed2 = new PotionEffect(PotionEffectType.SPEED, 5, 1);
	
	public Luigi(Player player, Plugin plugin) {
		super(player, "Luigi", "§2", plugin);	
	}

	@Override
	public void applyEffect() {
		
		Block block = player.getLocation().getBlock();
		
		if(block.getLightFromBlocks() < 3 && 
				block.getLightFromSky() < 3 || player.getWorld().getTime() >= 12000) {
			player.addPotionEffect(speed1);
		}
		
		if(player.getHealth() <= 3 && lowHealthBonus == false) {
			player.addPotionEffect(speed2);
			lowHealthBonus = true;
		}
		
		if(player.getHealth() > 3) {
			lowHealthBonus = false;
		}
	}

}
