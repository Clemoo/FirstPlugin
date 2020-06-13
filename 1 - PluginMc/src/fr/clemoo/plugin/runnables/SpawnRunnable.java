package fr.clemoo.plugin.runnables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnRunnable extends BukkitRunnable{
	
	private final Location spawnLocation = new Location(Bukkit.getWorld("world"), -50d,70d,219d, 90f, 1f);
	private int time = 4;
	private Player player;
	
	public SpawnRunnable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		if(time == 0) {
			player.teleport(spawnLocation);
			player.sendMessage(ChatColor.GREEN + "You have been successfully teleport to the spawn");
			cancel();
			return;
		}
		player.sendMessage(ChatColor.GOLD + "teleporation in " + time);
		time--;
	}

}
