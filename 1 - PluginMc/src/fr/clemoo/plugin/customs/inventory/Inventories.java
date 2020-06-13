package fr.clemoo.plugin.customs.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import fr.clemoo.plugin.customs.items.Items;

public class Inventories {
	
	private Items items = new Items();
	
	public Inventory createMenuInventory() {
		
		Inventory menu = Bukkit.createInventory(null, 36, ChatColor.RED + "Menu");
		menu.setItem(4, items.createArrowMenuItem());
		menu.setItem(13, items.createRedMushroomMenuItem());
		menu.setItem(22, items.createGoldenAppleMenuItem());
		menu.setItem(31, items.createPaperMenuItem());
		return menu;
		
	}

}
