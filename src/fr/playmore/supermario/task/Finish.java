package fr.playmore.supermario.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.entity.FireWork;

public class Finish extends BukkitRunnable{
	
	private Plugin plugin;
	private int timer;
	private Player winner;
	
	private ArrayList<Type> types = new ArrayList<Type>(Arrays.asList(Type.BALL, Type.BALL_LARGE, Type.BURST, Type.CREEPER, Type.STAR));
	
	private Random random = new Random();
	
	public Finish(Plugin plugin, Player winner) {
		this.plugin = plugin;
		this.winner = winner;
		this.timer = 300;
	}
	
	
	
	@Override
	public void run() {
		
		int type = random.nextInt(4);
		FireWork fire = new FireWork(winner.getLocation(), Color.RED, Color.GREEN, types.get(type));
		fire.summon();
		
		if(timer == 0 || !plugin.isState(State.FINISH)) {
			
			cancel();
		}
	}

}
