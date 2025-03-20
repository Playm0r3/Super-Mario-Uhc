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
import fr.playmore.supermario.utils.CustomInventory;

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
					CustomInventory.OpenSelectClassInventory(s);
					return true;
				} catch (IllegalArgumentException
						|SecurityException e) {
					e.printStackTrace();
				}
				
				return false;
			}
			
			return false;
		}
		
		return false;
	}

}
