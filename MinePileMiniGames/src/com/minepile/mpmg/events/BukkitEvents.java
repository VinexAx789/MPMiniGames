package com.minepile.mpmg.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.minepile.mpmg.MPMGMain;
import com.minepile.mpmg.util.ChatManager;
import com.minepile.mpmg.util.CountDownManager;

public class BukkitEvents implements Listener {
	
	//Load objects
	MPMGMain plugin;
	private ChatManager chatManager = new ChatManager();
	private PlayerJoinMiniGameEvent playerJoinMGEvent = new PlayerJoinMiniGameEvent();
	
	public BukkitEvents(MPMGMain plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	//PlayerJoinEvent fired when someone logs into server
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		//Debug messages
		chatManager.debugMessage("PlayerJoinEvent fired");
		
		//Toggle player join minigame event!
		playerJoinMGEvent.togglePlayerJoinMiniGameEvent(player);
	}
	
	//PlayerJoinEvent fired when someone leaves/quits the server
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {}
	
	//PlayerRespawnEvent fired when someone respawns after death
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {}
 
}
