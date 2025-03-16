package fr.playmore.supermario.roles;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.playmore.supermario.title.Title;
import fr.playmore.supermario.utils.Color;
import fr.playmore.supermario.utils.Timer;

public abstract class Mario extends Role implements Listener{
	
	Title title = new Title();
	PotionEffect marioEffectStrenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0);
	PotionEffect marioEffectResistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 1);
	
	public Mario() {
		super("Mario", Color.RED);
	}
	
	private long timeToResetMushroom = 30;
	private Timer timer;
	
	private int mushroom = 0;
	
	@Override
	public void ApplyEffect() {
		
		title.sendActionBar(player, color.s + "Champignon mangé : " + mushroom);
		
		if(mushroom >= 10)
		{
			mushroom = 0;
			player.addPotionEffects(Arrays.asList(marioEffectStrenght, marioEffectResistance));
		}
		
		if(timer.Check())
			mushroom = 0;
	}
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent event)
	{
		if(event.getPlayer().equals(player) && event.getItem().getType().equals(Material.RED_MUSHROOM))
		{
			mushroom += 1;
			timer = new Timer(timeToResetMushroom);
		}
	}
}