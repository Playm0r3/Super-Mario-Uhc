package fr.playmore.supermario.math;

import org.bukkit.Location;
import org.bukkit.World;

public class Vector3 {
	
	public double x;
	public double y;
	public double z;
	
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(double d) {
		this.x = d;
		this.y = d;
		this.z = d;
	}
	
	public Vector3 translate(Vector3 vector) {
		return new Vector3(this.x + vector.x, this.y + vector.y, this.z + vector.z);
	}
	
	public Location getLocation(World world) {
		return new Location(world, x, y, z);
	}

}
