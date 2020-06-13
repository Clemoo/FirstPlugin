package fr.clemoo.plugin.runnables;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.clemoo.plugin.listeners.PlayerChatAsync;

public class CooldownMessageRunnable extends BukkitRunnable {
	
	private Player player;
	
	public CooldownMessageRunnable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		PlayerChatAsync.getCooldownMessage().remove(player);
	}

}
