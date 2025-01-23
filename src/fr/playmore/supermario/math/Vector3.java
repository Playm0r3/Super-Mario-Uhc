package fr.playmore.supermario.math;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

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
	
	public Vector3(Vector3 start, Vector3 destination) {
		this.x = destination.y - start.x;
		this.y = destination.y - start.y;
		this.z = destination.z - start.z;
	}
	
	public double Norm() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector3 translate(Vector3 vector) {
		return new Vector3(this.x + vector.x, this.y + vector.y, this.z + vector.z);
	}
	
	public Location getLocation(World world) {
		return new Location(world, x, y, z);
	}
	
	public static double getDistancePlayers(Player player1, Player player2) {
		Vector3 player1Position = new Vector3(player1.getLocation().getX(), player1.getLocation().getY(), player1.getLocation().getZ());
		Vector3 player2Position = new Vector3(player2.getLocation().getX(), player2.getLocation().getY(), player2.getLocation().getZ());
		Vector3 vector = new Vector3(player1Position, player2Position);
		return vector.Norm();
	}

}
