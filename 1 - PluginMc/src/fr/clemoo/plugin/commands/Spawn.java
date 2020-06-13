package fr.clemoo.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.clemoo.plugin.Plugin;
import fr.clemoo.plugin.runnables.SpawnRunnable;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "you can't execute this command");
			return false;
		}
		Player player = (Player) sender;
		new SpawnRunnable(player).runTaskTimer(Plugin.getInstance(), 0L, 20L);
		return true;
	}

}
