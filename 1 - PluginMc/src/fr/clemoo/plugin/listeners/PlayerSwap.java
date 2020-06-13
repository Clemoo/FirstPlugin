package fr.clemoo.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerSwap implements Listener{

	@EventHandler
	public void onSwap(PlayerSwapHandItemsEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(event.getMainHandItem() + "hello");
	}
	
}
