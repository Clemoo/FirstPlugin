package fr.clemoo.plugin.managers;

public enum Rank {
	
	DEFAULT(1, "default", "§dDEFAULT", "§f"),
	PLAYER(2, "player", "§7PLAYER", "§7"),
	MODERATOR(3, "moderator", "§6MOD", "§e"),
	ADMINISTRATOR(4, "administrator", "§cADMIN", "§4");
	
	private int id;
	private String name, prefix, suffix;
	
	private Rank(int id, String name, String prefix, String suffixe) {
		this.id = id;
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffixe;
	}
	
	public static Rank getRankByName(String name) {
		for(Rank rank : Rank.values()) {
			if(rank.getName().equals(name)) {
				return rank;
			}
		}
		return Rank.DEFAULT;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
}
