package fr.playmore.supermario.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomInventory {

	public static ItemStack GetMarioItem()
	{
		ItemStack it = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta itm = it.getItemMeta();
		itm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itm.setLore(Arrays.asList("It's a Toad ?"));
		it.setItemMeta(itm);
		return it;
	}
}
