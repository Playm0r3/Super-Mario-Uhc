package fr.playmore.supermario.utils;

import org.bukkit.inventory.ItemStack;

import fr.playmore.supermario.roles.Role;

public class CustomItem {
	
	private ItemStack item;
	private Role role;
	
	public CustomItem(ItemStack i, Role r)
	{
		this.item = i;
		this.role = r;
	}
	
	public ItemStack GetItem()
	{
		return item;
	}
	
	public Role GetRole()
	{
		return role;
	}
}
