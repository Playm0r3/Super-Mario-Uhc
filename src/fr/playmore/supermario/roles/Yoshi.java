package fr.playmore.supermario.roles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.playmore.supermario.utils.Color;

public class Yoshi extends Role implements Listener{

	public Yoshi() {
		super("Yoshi", Color.LIME);
	}
	
	private float damageReduce = 0.75f;

	@Override
	public void ApplyEffect() {
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event)
	{
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			String dn = Joueur.GetJoueur(p).role.name;
			if(dn == "Mario" || dn == "Luigi" || dn == "Peach" || dn == "Daisy")
			{
				event.setDamage(event.getDamage() * damageReduce);
			}
		}
	}
}
