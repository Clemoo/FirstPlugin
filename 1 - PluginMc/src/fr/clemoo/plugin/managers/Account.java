package fr.clemoo.plugin.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Account {
	
	private UUID uuid;
	
	public Account(UUID uuid) {
		this.uuid = uuid;
	}
	
	public boolean hasAccount() {
		try {
			PreparedStatement preparedStatement = Database.getConnection().prepareStatement("SELECT password FROM players WHERE uuid = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.close();
				preparedStatement.close();
				return true;
			}
			resultSet.close();
			preparedStatement.close();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void createAccount() {
		if(!hasAccount()) {
			try {
				PreparedStatement preparedStatement = Database.getConnection().prepareStatement("INSERT INTO players (pseudo, uuid, password, hierarchy) VALUES (?,?,?,?)");
				preparedStatement.setString(1, Bukkit.getPlayer(uuid).getDisplayName());
				preparedStatement.setString(2, uuid.toString());
				preparedStatement.setString(3, "none");
				preparedStatement.setString(4, Rank.PLAYER.getName());
				preparedStatement.execute();
				preparedStatement.close();
				Bukkit.getPlayer(uuid).sendMessage(ChatColor.GREEN + "Your account was successfully created");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAccount() {
		if(hasAccount()) {
			try {
				PreparedStatement preparedStatement = Database.getConnection().prepareStatement("DELETE FROM players WHERE uuid = ?");
				preparedStatement.setString(1, uuid.toString());
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public String getPassword() {
		try {
			PreparedStatement preparedStatement = Database.getConnection().prepareStatement("SELECT password FROM players WHERE uuid = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("password");
			}
			resultSet.close();
			preparedStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "none";
	}
	
	public void setPassword(String password) {
		try {
			PreparedStatement preparedStatement = Database.getConnection().prepareStatement("UPDATE players SET password = ? WHERE uuid = ?");
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, uuid.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getRankName() {
		try {
			PreparedStatement preparedStatement = Database.getConnection().prepareStatement("SELECT hierarchy FROM players WHERE uuid = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("hierarchy");
			}
			resultSet.close();
			preparedStatement.close();
			return "player";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "default";
	}

}
