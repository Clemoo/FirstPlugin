package fr.clemoo.plugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.clemoo.plugin.managers.ManagerPlugin;

public class Plugin extends JavaPlugin {
	
	private static Plugin instance;
	private ManagerPlugin manager = new ManagerPlugin();
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\nHello, this is a test for start");
		manager.registerCommands();
		manager.registerListeners();
		manager.getDatabase().connection();
		
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\nGoodbye, this is a test for stop");
		manager.getDatabase().disconnection();
	}
	
	public static Plugin getInstance() {
		return instance;
	}

}
