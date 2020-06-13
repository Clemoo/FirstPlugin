package fr.clemoo.plugin.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener{
	
	@EventHandler
	public void onInterfact(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if(event.getAction() == null) {
			return;
		}
		
		if(event.getAction().equals(org.bukkit.event.block.Action.LEFT_CLICK_BLOCK)){
			
			switch(event.getClickedBlock().getType()) {
				case GRASS_BLOCK:
					player.sendMessage("wowwww");
					break;
				default:
					player.sendMessage(block.getType() + "");
					break;
			}
		
		}
		
	}

}
