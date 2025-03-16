package fr.playmore.supermario.roles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.playmore.supermario.title.Title;
import fr.playmore.supermario.utils.Color;
import fr.playmore.supermario.utils.Timer;

public class Luigi extends Role implements Listener{

	Title title = new Title();
	PotionEffect LuigiSpeed2Effect = new PotionEffect(PotionEffectType.SPEED, 5, 1);
	PotionEffect LuigiSpeedEffect = new PotionEffect(PotionEffectType.SPEED, 1, 0);
	
	public Luigi() {
		super("Luigi", Color.GREEN);
	}
	
	private long speedSeconds = 5;
	private long passifCooldown = 30;
	private Timer timer = new Timer(speedSeconds);
	
	@Override
	public void ApplyEffect() {
		if(player.getLocation().getBlock().getLightLevel() < 3)
			player.addPotionEffect(LuigiSpeedEffect);
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event)
	{
		Player p = (Player) event.getEntity();
		
		if(player.equals(p))
		{
			if(event.getDamager() instanceof Player)
			{
				if(timer.Check())
				{
					timer = new Timer(passifCooldown);
					player.addPotionEffect(LuigiSpeed2Effect);
				}
			}
		}
	}
}
