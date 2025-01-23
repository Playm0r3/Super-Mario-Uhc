package fr.playmore.supermario.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import fr.playmore.supermario.Plugin;

public class WorldManager {
	
	public static void fill(World world, Location start, Location end, Material mat) {
		
		if(start.getWorld() != end.getWorld()) {
			return;
		}
		
		double minX = Math.min(start.getX(), end.getX());
		double maxX = Math.max(start.getX(), end.getX());
		double minY = Math.min(start.getY(), end.getY());
		double maxY = Math.max(start.getY(), end.getY());
		double minZ = Math.min(start.getZ(), end.getZ());
		double maxZ = Math.max(start.getZ(), end.getZ());

		for (double x = minX; x <= maxX; x++) {
			for (double y = minY; y <= maxY; y++) {
				for (double z = minZ; z <= maxZ; z++) {
					world.getBlockAt(new Location(world, x, y, z)).setType(mat);;
				}
			}
		}
	}
	
	public static void createSpawn(World world, int _x, int _z, int x2, int z2) {
		
		System.out.print("Generation du spawn");
		fill(world, new Location(world, x2 - 1, 199, z2 - 1), new Location(world, _x, 199, _z), Material.BARRIER);
		fill(world, new Location(world, x2 - 1, 199, z2 - 1), new Location(world, _x, 205, z2 - 1), Material.BARRIER);
		fill(world, new Location(world, _x, 199, z2 - 1), new Location(world, _x, 205, _z), Material.BARRIER);
		fill(world, new Location(world, _x, 199, _z), new Location(world, x2 - 1, 205, _z), Material.BARRIER);
		fill(world, new Location(world, x2 - 1, 199, _z), new Location(world, x2 - 1, 205, z2 - 1), Material.BARRIER);
		System.out.print("Spawn genere ! (done)");
		
	}
	
	public static void LoadWorld(Plugin plugin) {
		plugin.overworld = Bukkit.getWorld("world");
		plugin.nether = Bukkit.getWorld("world_nether");
		plugin.end = Bukkit.getWorld("world_the_end");
	}


}
