package fr.clemoo.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.clemoo.plugin.listeners.PlayerJoin;
import fr.clemoo.plugin.managers.Account;

public class Register implements CommandExecutor{
	
	private Account account;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		account = new Account(player.getUniqueId());
		if(args.length == 2) {
			if(PlayerJoin.getAttemptRegister().contains(player)) {
				if(args[0].equals(args[1])) {
					account.setPassword(args[0]);
					player.sendMessage(ChatColor.GREEN + "You are registered");
					PlayerJoin.getAttemptRegister().remove(player);
					return true;
				}
				player.sendMessage(ChatColor.DARK_RED + "Password are not equals");
				return false;
			}
			player.sendMessage(ChatColor.RED + "You already register your accont");
			return false;
		}
		player.sendMessage(ChatColor.RED + "invalid command, use /register <password><password>");
		return false;
	}

}
