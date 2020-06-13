package fr.clemoo.plugin.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import fr.clemoo.plugin.Plugin;
import fr.clemoo.plugin.commands.Calcul;
import fr.clemoo.plugin.managers.Account;
import fr.clemoo.plugin.managers.Rank;
import fr.clemoo.plugin.runnables.CalculRunnable;
import fr.clemoo.plugin.runnables.CooldownMessageRunnable;

public class PlayerChatAsync implements Listener{
	
	private static List<Player> cooldownMessage = new ArrayList<>();
	private static List<Player> cooldownCalcul = new ArrayList<>();
	private static CalculRunnable calculRunnable;
	private Account account;
	
	@EventHandler
	public void onChatAsync(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		account = new Account(player.getUniqueId());
		String message = event.getMessage();
		event.setFormat(Rank.getRankByName(account.getRankName()).getPrefix() + " " + player.getDisplayName() + " §8>> " + Rank.getRankByName(account.getRankName()).getSuffix() + message);
		if(cooldownMessage.contains(player)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "Please wait before send a new message");
		}else if(!(Rank.getRankByName(account.getRankName()).equals(Rank.ADMINISTRATOR)) && (!(Rank.getRankByName(account.getRankName()).equals(Rank.MODERATOR)))){
			cooldownMessage.add(player);
			new CooldownMessageRunnable(player).runTaskLater(Plugin.getInstance(), 100L);
		}else if(Calcul.getCalculPlayers().contains(player)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You have to answer to " + ChatColor.GOLD + Calcul.getCurrentCalculWithResult().get(Calcul.getResult()));
			if(message.equals(Calcul.getResult().toString())) {
				player.sendMessage(ChatColor.GREEN + "You founded the good result, it was " + ChatColor.YELLOW + Calcul.getResult());
				Calcul.getCalculPlayers().remove(player);
				cooldownCalcul.add(player);
				calculRunnable = new CalculRunnable(player);
				calculRunnable.runTaskTimer(Plugin.getInstance(), 0L, 20L);
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
				player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK, 4));
			}else {
				player.sendMessage(ChatColor.RED + "You havn't found the good result, please try again ;)");
			}
		}
	
	}
	
	public static List<Player> getCooldownMessage() {
		return cooldownMessage;
	}
	
	public static List<Player> getCooldownCalcul() {
		return cooldownCalcul;
	}

	public static int getTime() {
		return calculRunnable.getTime();
	}
	
}
