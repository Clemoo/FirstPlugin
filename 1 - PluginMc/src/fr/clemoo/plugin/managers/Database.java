package fr.clemoo.plugin.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.ChatColor;

import fr.clemoo.plugin.Plugin;

public class Database {
	
	private String urlBase, host, database, username, password;
	private int port;
	private static Connection connection;
	
	public Database(String urlBase, String host, int port, String database, String username, String password) {
		this.urlBase = urlBase;
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	private boolean isOnline() {
		try {
			if(connection == null || connection.isClosed()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void connection() {
		if(!isOnline()) {
			try {
				connection = DriverManager.getConnection(this.urlBase + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
				Plugin.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully connection");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void disconnection() {
		if(isOnline()) {
			try {
				connection.close();
				Plugin.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.RED + "Successufully disconnection");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
