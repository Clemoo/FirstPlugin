package fr.clemoo.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.clemoo.plugin.listeners.PlayerJoin;
import fr.clemoo.plugin.managers.Account;

public class Login implements CommandExecutor{
	
	private Account account;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		account = new Account(player.getUniqueId());
		if(args.length == 1) {
			if(PlayerJoin.getAttemptLogin().contains(player)) {
				if(args[0].equals(account.getPassword())) {
					player.sendMessage(ChatColor.GREEN + "You are logged");
					PlayerJoin.getAttemptLogin().remove(player);
				}else {
					player.sendMessage(ChatColor.RED + "Invalid password, please retry");
				}
			}else {
				player.sendMessage(ChatColor.GREEN + "You're already login");
			}
			return false;
		}
		player.sendMessage(ChatColor.RED + "Invalid command, please use /login <password, default=none>");
		return false;
	}
	
}