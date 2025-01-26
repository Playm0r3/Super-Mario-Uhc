package fr.playmore.supermario.roles;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.utils.Timer;

public class Mario extends Roles {

	private int mushroom = 0;
	
	private boolean smallBoost = false;
	private boolean bigBoost = false;
	
	private Timer timer;
	private Timer effect;
	
	private PotionEffect strenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0);
	
	public static int playerWithMarioRole = 0;
	public static int maxPlayers;
	
	public Mario(Player player, Plugin plugin) {
		super(player, "Mario", "4", plugin);
		maxPlayers = plugin.getConfig().getInt("role.mario.playerMax");
	}

	@Override
	public void applyEffect() {
		
		if(mushroom >= 3 && smallBoost == false && bigBoost != true) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 180, 0));
			effect = new Timer(180);
			smallBoost = true;
		}
		
		if(mushroom >= 10 && smallBoost == true && bigBoost != true) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 1));
			player.addPotionEffect(strenght);
			effect = new Timer(120);
			mushroom = 0; bigBoost = true;
		}
		
		if(effect.Finish() || timer.Finish()) {
			mushroom = 0; bigBoost = false; smallBoost = false; timer = null;
		}
		
	}
	
	public int getMushroom() {
		return mushroom;
	}
	
	@EventHandler
	public void eat(PlayerItemConsumeEvent event) {
		if(event.getPlayer() == player) {
			if(event.getItem().getType().equals(Material.RED_MUSHROOM) ||
					event.getItem().getType().equals(Material.BROWN_MUSHROOM)) {
				
				timer = new Timer(10);
				mushroom += 1;
			}
		}
	}

}
