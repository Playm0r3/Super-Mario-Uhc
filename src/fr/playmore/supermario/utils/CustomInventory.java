package fr.playmore.supermario.utils;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomInventory {

	public static void OpenSelectClassInventory(Player player)
	{
		Inventory inv = Bukkit.createInventory(player, 9, "Select Class");
		
		inv.addItem(CustomInventory.GetMarioItem());
		inv.addItem(CustomInventory.GetLuigiItem());
		
		// mettre les autre role a la suite;
		
		player.openInventory(inv);
	}
	
	public static ItemStack GetMarioItem()
	{
		ItemStack it = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("It's a Toad ?"));
		it.setItemMeta(itm);
		return it;
	}
	
	public static ItemStack GetLuigiItem()
	{
		ItemStack it = new ItemStack(Material.GHAST_TEAR);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("who's tear ?"));
		it.setItemMeta(itm);
		return it;
	}
	
	public static ItemStack GetPeachItem()
	{
		ItemStack it = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("Don't eat that !"));
		it.setItemMeta(itm);
		return it;
	}
	
	public static ItemStack GetDaisyItem()
	{
		ItemStack it = new ItemStack(Material.SANDSTONE);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("Royal sand ?"));
		it.setItemMeta(itm);
		return it;
	}
	
	public static ItemStack GetYoshiItem()
	{
		ItemStack it = new ItemStack(Material.EGG);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("Egg's Yoshi"));
		it.setItemMeta(itm);
		return it;
	}
}
