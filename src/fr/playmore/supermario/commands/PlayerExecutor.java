package fr.playmore.supermario.commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.roles.Joueur;
import fr.playmore.supermario.roles.Role;

public class PlayerExecutor  implements CommandExecutor{

	
	private Plugin plugin;
	
	public PlayerExecutor(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player)
		{
			Player s = (Player) sender;
			if(cmd.getName().equals("mu") && args.length == 1)
			{
				try {
					Class<?> clazz = Class.forName("fr.playmore.supermario." + args[1]);
					Constructor<?> constructor = clazz.getConstructor();
					Joueur joueur = new Joueur(s, (Role) constructor.newInstance());
					Joueur.inGame.put(s, joueur);
					return true;
				} catch (ClassNotFoundException |InstantiationException|IllegalAccessException|IllegalArgumentException
						|InvocationTargetException|NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				return false;
			}
			
			return false;
		}
		
		return false;
	}

}
