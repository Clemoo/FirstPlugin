package fr.clemoo.plugin.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.clemoo.plugin.listeners.PlayerChatAsync;

public class Calcul implements CommandExecutor{
	
	private static List<Player> calculPlayers = new ArrayList<>();
	private static Map<Integer, String> currentCalculWithResult = new HashMap<>();
	private static Integer result;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(PlayerChatAsync.getCooldownCalcul().contains((Player) sender))) {
			
			if(calculPlayers.contains((Player) sender)){
				sender.sendMessage(ChatColor.RED + "You already need to answer to " + currentCalculWithResult.get(result));
				return false;
			}
			currentCalculWithResult.clear();
			String[] calcul = generateCalcul();
			sender.sendMessage(ChatColor.GOLD + "------------------" + ChatColor.RED + "CALCUL" + ChatColor.GOLD + "-------------------");
			sender.sendMessage("Your calcul is " + ChatColor.GOLD + calcul[0]);
			calculPlayers.add((Player) sender);
			currentCalculWithResult.put(Integer.parseInt(calcul[1]), calcul[0]);
			sender.sendMessage(ChatColor.GOLD + "-------------------------------------------");
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "You can execute this command in " + ChatColor.RED + (PlayerChatAsync.getTime())/60 + ChatColor.GOLD + " minutes");
		return false;
	}
	
	public String[] generateCalcul() {
		int a = (int) (Math.random()*100+1);
		int b = (int) (Math.random()*100+1);
		int result = 0;
		char c = ' ';
		int operation = (int) (Math.random()*4+1);
		/*
		 *'/' out, too hard
		 */
		switch(operation) {
			case 1:
				c = '+';
				result = a + b;
				break;
			case 2:
				c = '-';
				result = a-b;
				break;
			case 3:
				c = '*';
				result =  a*b;
				break;
			case 4:
				c = '+';
				result = a+b;
				break;
			default:
				break;
		}
		Calcul.result = result;
		String[] total = {a + "" + c + "" + b, result + ""};
		return total;
	}
	
	public static List<Player> getCalculPlayers() {
		return calculPlayers;
	}
	
	public static Map<Integer, String> getCurrentCalculWithResult() {
		return currentCalculWithResult;
	}
	
	public static Integer getResult() {
		return result;
	}
	
}
