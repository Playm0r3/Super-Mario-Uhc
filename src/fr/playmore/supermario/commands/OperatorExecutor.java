package fr.playmore.supermario.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.playmore.supermario.Plugin;
import fr.playmore.supermario.State;
import fr.playmore.supermario.roles.Role;
import fr.playmore.supermario.task.Start;

public class OperatorExecutor implements CommandExecutor{

	private Plugin plugin;
	
	public OperatorExecutor(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.isOp()) {
				if(cmd.getName().equals("start") && plugin.isState(State.WAITTING)) {
					if(args.length > 1) {
						player.sendMessage(plugin.prefixPlugin + " §cErreur de Syntaxe §7: /start <time>");
						player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.f, 1.f);
						return true;
					}
					if(args.length < 1) {
						plugin.setState(State.STARTING);
						Start start = new Start(plugin, 10);
						start.runTaskTimer(plugin, 0, 20);
						return true;
					}
					if(args.length == 1) {
						try {
							Start start = new Start(plugin, Integer.parseInt(args[0]));
							start.runTaskTimer(plugin, 0, 20);
							plugin.setState(State.STARTING);
						}catch(NumberFormatException e) {
							player.sendMessage(plugin.prefixPlugin + " §cErreur de syntaxe §7: /start <time>");
							player.sendMessage("§7<time> doit être une valuer numérique");
							player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.f, 1.f);
						}
						return true;
					}
				} else if(cmd.getName().equals("start") && !plugin.isState(State.WAITTING)) {
					player.sendMessage(plugin.prefixPlugin + " Vous ne pouvez pas lancer la partie après l'avoir lancé");
					player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.f, 1.f);
					return true;
				}
				if(cmd.getName().equals("state")) {
					if(args.length > 0) {
						player.sendMessage(plugin.prefixPlugin + " §cErreur de syntaxe §7: /state");
						return true;
					}
					
					player.sendMessage(plugin.prefixPlugin + " Etat de la partie : §2" + plugin.getState() + "§r");
					return true;
				}
				if(cmd.getName().equals("add") && !plugin.isState(State.WAITTING)) {
					
					if(args.length < 2 || args.length > 2) {
						player.sendMessage(plugin.prefixPlugin + " §cErreur de syntaxe §7: /add <type> <name>");
						return false;
					}
					/*
					if(args[0].equals("role")) {
						
						try {
							Class<?> clazz = Class.forName("fr.playmore.supermario." + args[1]);
							if(clazz.getConstructors().length == 1)
							player.sendMessage(plugin.prefixPlugin + " Le role : " + args[1] + " à été ajouté à la liste");
							return true;
						} catch(Exception e) {
							e.printStackTrace();
							player.sendMessage(plugin.prefixPlugin + " Erreur de syntaxe le role n'existe surment pas");
						}
						return false;
					}
					*/
				}
			}
		}
		
		//mettre code pour les commandes operator via la console du server
		
		if(sender instanceof ConsoleCommandSender) {
			if(cmd.getName().equals("start") && plugin.isState(State.WAITTING)) {
				
				if(args.length > 1) {
					System.out.print("Erreur de syntaxe : start <time>");
					return true;
				}
				
				if(args.length < 1) {
					plugin.setState(State.STARTING);
					Start start = new Start(plugin, 10);
					start.runTaskTimer(plugin, 0, 20);
					return true;
				}
				
				if(args.length == 1) {
					
					try {
						Start start = new Start(plugin, Integer.parseInt(args[0]));
						start.runTaskTimer(plugin, 0, 0);
						plugin.setState(State.STARTING);
					}catch(NumberFormatException e) {
						System.out.print("Erreur le nombre de seconde n'est pas valide !");
						System.out.print("Syntaxe : start <Nombre>");
					}
					return true;
				}
				
			}else if(cmd.getName().equals("start") && !plugin.isState(State.WAITTING)) {
				System.out.print("Erreur : vous ne pouvez pas executer cette commande quand la partie est en phase : " + plugin.getState());
				return true;
			}
			
			if(cmd.getName().equals("state")) {
				if(args.length > 0) {
					System.out.print("Erreur de syntaxe : state");
					return true;
				}
				
				System.out.print("Etat de la partie : " + plugin.getState());
				return true;
			}
		}
		
		return false;
	}

}
