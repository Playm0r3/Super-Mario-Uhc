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

public class Peach extends Role implements Listener{

	Title title = new Title();
	PotionEffect peachEffect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
	
	public Peach() {
		super("Peach", Color.PINK);
	}

	private long passifCooldown = 60;
	
	private Timer timer = new Timer(5);
	
	@Override
	public void ApplyEffect() {
		//empty 
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event){
		Player p = (Player) event.getEntity();

		if(player.equals(p) && event.getDamager() instanceof Player){
			if(timer.Check())
			{
				timer = new Timer(passifCooldown);
				player.addPotionEffect(peachEffect);
			}
		}
	}
}
