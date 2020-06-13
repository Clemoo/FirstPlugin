package fr.clemoo.plugin.customs.items;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	public ItemStack createArrowMenuItem() {
		ItemStack arrowStack = new ItemStack(Material.ARROW);
		ItemMeta arrowMeta = arrowStack.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.GREEN + "SPAWN");
		arrowMeta.setLore(Arrays.asList("Go to spawn now"));
		arrowStack.setItemMeta(arrowMeta);
		return arrowStack;
	}
	
	public ItemStack createGoldenAppleMenuItem() {
		ItemStack goldenAppleStack = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta goldenAppleMeta = goldenAppleStack.getItemMeta();
		goldenAppleMeta.setDisplayName(ChatColor.GOLD + "GET PASSWORD");
		goldenAppleMeta.setLore(Arrays.asList("Get your password now (safe❤)"));
		goldenAppleStack.setItemMeta(goldenAppleMeta);
		return goldenAppleStack;
	}
	
	public ItemStack createPaperMenuItem() {
		ItemStack paperStack = new ItemStack(Material.PAPER);
		ItemMeta paperMeta = paperStack.getItemMeta();
		paperMeta.setDisplayName(ChatColor.RED + "CALCUL");
		paperMeta.setLore(Arrays.asList("You have to be strong with calcul now"));
		paperStack.setItemMeta(paperMeta);
		return paperStack;
	}
	
	public ItemStack createRedMushroomMenuItem() {
		ItemStack redMushroomStack = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta redMushroomMeta = redMushroomStack.getItemMeta();
		redMushroomMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "WEBSITE");
		redMushroomMeta.setLore(Arrays.asList("Go to the website now"));
		redMushroomStack.setItemMeta(redMushroomMeta);
		return redMushroomStack;
	}

}
