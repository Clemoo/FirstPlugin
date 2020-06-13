package fr.clemoo.plugin.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.clemoo.plugin.managers.Account;
import fr.clemoo.plugin.managers.Rank;
import fr.clemoo.plugin.tools.TeamsTagsManager;

public class PlayerJoin implements Listener{
	
	private Account account;
	private static List<Player> attemptLogin = new ArrayList<>();
	private static List<Player> attemptRegister = new ArrayList<>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		account = new Account(player.getUniqueId());
		account.createAccount();
		
		TeamsTagsManager.setNameTag(player, Rank.getRankByName(account.getRankName()).getName(), Rank.getRankByName(account.getRankName()).getPrefix() + " ", Rank.getRankByName(account.getRankName()).getSuffix());
		
		if(account.getPassword().equals("none") || account.getPassword().equals(null)) {
			attemptRegister.add(player);
		}else {
			attemptLogin.add(player);
		}
		event.setJoinMessage(ChatColor.GOLD + "" + ChatColor.ITALIC + "Hello " + ChatColor.RED + "" + ChatColor.ITALIC + Rank.getRankByName(account.getRankName()).getPrefix() + " " + player.getDisplayName());
	}
	
	public static List<Player> getAttemptLogin() {
		return attemptLogin;
	}
	
	public static List<Player> getAttemptRegister() {
		return attemptRegister;
	}

}
