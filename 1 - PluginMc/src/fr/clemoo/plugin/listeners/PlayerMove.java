package fr.clemoo.plugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(PlayerJoin.getAttemptLogin().contains(player)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You need to login, use /login password<default=none>");
		}else if(PlayerJoin.getAttemptRegister().contains(player)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You need to register, use /register <password><password>");
		}
	}

}
