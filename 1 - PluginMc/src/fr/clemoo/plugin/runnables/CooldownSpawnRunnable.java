package fr.clemoo.plugin.runnables;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.clemoo.plugin.listeners.PlayerClickInventory;

public class CooldownSpawnRunnable extends BukkitRunnable{

	private Player player;
	
	public CooldownSpawnRunnable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		
		PlayerClickInventory.getCooldown().remove(player);
		
	}
	
}
