package fr.playmore.supermario.roles;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.playmore.supermario.utils.Color;

public class Daisy extends Role implements Listener{

	public Daisy(String name, Color color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}
	
	private float damageReduce = 0.80f;
	private float damageIncrease = 1.05f;
	private boolean inDesert = false;

	@Override
	public void ApplyEffect() {
		Biome biome = player.getLocation().getBlock().getBiome();
		if(biome.equals(Biome.DESERT) || biome.equals(Biome.DESERT_HILLS) || biome.equals(Biome.DESERT_MOUNTAINS)){
			if(!inDesert)
				inDesert = true;
			else
				inDesert = false;
		}
	}

	public void Damage(EntityDamageByEntityEvent event)
	{
		if(event.getEntity() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			if(player.equals(p) && inDesert)
			{
				event.setDamage(event.getDamage() * damageReduce);
			}
		}
		
		if(event.getDamager() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			if(player.equals(p) && player.getHealth() > 15)
			{
				event.setDamage(event.getDamage() * damageIncrease);
			}
		}
	}
	
}
