package fr.clemoo.plugin.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.clemoo.plugin.Plugin;
import fr.clemoo.plugin.commands.Calcul;
import fr.clemoo.plugin.commands.Login;
import fr.clemoo.plugin.commands.Menu;
import fr.clemoo.plugin.commands.Register;
import fr.clemoo.plugin.commands.Spawn;
import fr.clemoo.plugin.commands.Test;
import fr.clemoo.plugin.listeners.PlayerChatAsync;
import fr.clemoo.plugin.listeners.PlayerClickInventory;
import fr.clemoo.plugin.listeners.PlayerInteract;
import fr.clemoo.plugin.listeners.PlayerJoin;
import fr.clemoo.plugin.listeners.PlayerMove;
import fr.clemoo.plugin.listeners.PlayerQuit;
import fr.clemoo.plugin.listeners.PlayerSwap;

final public class ManagerPlugin {
	
	private final PluginManager pluginManager = Bukkit.getPluginManager();
	private final Database database = new Database("jdbc:mysql://", "localhost" , 3308, "info_players", "root", "");
	
	public void registerListeners() {
		pluginManager.registerEvents(new PlayerJoin(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerClickInventory(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerInteract(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerSwap(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerQuit(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerMove(), Plugin.getInstance());
		pluginManager.registerEvents(new PlayerChatAsync(), Plugin.getInstance());
		
	}
	
	public void registerCommands() {
		Plugin.getInstance().getCommand("test").setExecutor(new Test());
		Plugin.getInstance().getCommand("spawn").setExecutor(new Spawn());
		Plugin.getInstance().getCommand("menu").setExecutor(new Menu());
		Plugin.getInstance().getCommand("login").setExecutor(new Login());
		Plugin.getInstance().getCommand("register").setExecutor(new Register());
		Plugin.getInstance().getCommand("calcul").setExecutor(new Calcul());
	}
	
	public Database getDatabase() {
		return database;
	}
	
}
