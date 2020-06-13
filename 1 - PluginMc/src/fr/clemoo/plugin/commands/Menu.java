package fr.clemoo.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.clemoo.plugin.customs.inventory.Inventories;

public class Menu implements CommandExecutor {
	
	private Inventories menu = new Inventories();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You can't execute this command");
			return false;
		}
		Player player = (Player) sender;
		player.openInventory(menu.createMenuInventory());
		return true;
	}

}
