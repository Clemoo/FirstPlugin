package fr.clemoo.plugin.runnables;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.clemoo.plugin.listeners.PlayerChatAsync;

public class CalculRunnable extends BukkitRunnable{
	
	private Player player;
	private int time = 3600;
	
	public CalculRunnable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		if(time == 0) {
			PlayerChatAsync.getCooldownCalcul().remove(player);
			cancel();
			return;
		}
		time--;
	}
	
	public int getTime() {
		return time;
	}
	
}
