package fr.playmore.supermario.entity;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireWork {
	
	public Location location;
	public World world;
	public Color color1;
	public Color color2;
	public Type type;
	
	public FireWork(Location loc, Color color1, Color color2, Type type) {
		this.location = loc;
		this.world = (World) loc.getWorld();
		this.color1 = color1;
		this.color2 = color2;
		this.type = type;
	}
	
	public void summon() {
		Firework fire = world.spawn(location, Firework.class);
		FireworkMeta fm = (FireworkMeta) fire.getFireworkMeta();
		fm.addEffects(FireworkEffect.builder().withColor(color1).withColor(color2).with(type).withFlicker().build());
		fm.setPower(3);
		fire.setFireworkMeta(fm);
	}
}
