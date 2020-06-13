package fr.clemoo.plugin.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.clemoo.plugin.Plugin;
import fr.clemoo.plugin.customs.items.Items;
import fr.clemoo.plugin.managers.Account;
import fr.clemoo.plugin.runnables.CooldownSpawnRunnable;

public class PlayerClickInventory implements Listener{
	
	private Items items = new Items();
	private static List<Player> cooldown = new ArrayList<>();
	private Account account;
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) {
			event.getWhoClicked().sendMessage(ChatColor.RED + "You can't execute this command");
			return;
		}
		Player player = (Player) event.getWhoClicked();
		account = new Account(player.getUniqueId());
		ItemStack clickedItem = event.getCurrentItem();
		Inventory currentInventory = event.getClickedInventory();
		ClickType clickType = event.getClick();
		
		if(clickedItem == null) {
			return;
		}
		if(currentInventory == null) {
			return;
		}
		if(cooldown.contains(player)) {
			event.setCancelled(true);
			return;
		}
		//player.sendMessage(event.getAction() + "");
		
		if(event.getView().getTitle().equals(ChatColor.RED + "Menu")) {
			event.setCancelled(true);
			if(clickedItem.equals(items.createArrowMenuItem())) {
				if(clickType.equals(ClickType.CREATIVE) || clickType.equals(ClickType.LEFT)) {
					cooldown.add(player);
					new CooldownSpawnRunnable(player).runTaskLater(Plugin.getInstance(), 100L);
					player.sendMessage("I love youu");
					player.performCommand("spawn");
				}
			}else if(clickedItem.equals(items.createGoldenAppleMenuItem())) {
				if(clickType.equals(ClickType.CREATIVE) || clickType.equals(ClickType.LEFT)) {
					player.sendMessage(ChatColor.YELLOW + "Your password is " + ChatColor.RED + account.getPassword());
				}
			}else if(clickedItem.equals(items.createPaperMenuItem())) {
				if(clickType.equals(ClickType.LEFT) || clickType.equals(ClickType.LEFT)) {
					player.performCommand("calcul");
				}
			}
		}
	}
	
	public static List<Player> getCooldown() {
		return cooldown;
	}

}
