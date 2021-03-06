package com.minepile.mpmg.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import com.minepile.mpmg.util.TeamManager;

public class MiniGameCTF extends MiniGame {
	
	//Load objects.
	
	//Variables that Make a MiniGame
	//private String[] kits = {"Kit 1"};
	//private String[] teams = {"Red", "Blue"};
	
	//Variables to give user info
	private String miniGameName = "Capture the flag!";
	private String miniGameDescription = "Who ever gets the most flags win!";
	private String worldAuthor = "unenergizer";
	//private List<Location> redSpawns = {world, 0.5, 84, 0.5};
	
	//Game specific variables.
	
	//Define constructor instructions
	public MiniGameCTF() {}
	
	@Override
	public void loadMiniGame() {
		if (isMapLoaded() == false) {
			setMapLoaded(true);
			//Load next world
			WorldCreator worldCreator = new WorldCreator("CTF");
			worldCreator.createWorld();
			World world = Bukkit.getWorld("CTF");
			world.setPVP(true);
			world.setStorm(false);
			world.setMonsterSpawnLimit(0);
			world.setAnimalSpawnLimit(0);
			world.setSpawnFlags(false, false);
			//Get all players online in an array, and teleport them all and play a sound
			for(Player players : Bukkit.getServer().getOnlinePlayers()) {
				//chatManager.debugMessage(TeamManager.getTeamHashMap().toString());
				if(TeamManager.getPlayerTeam(players) == "red"){
					//redteam spawn
					Location teleportloc = new Location(world, 0.5, 80, 29.5);
					players.teleport(teleportloc); //Teleport player
					players.setPlayerTime(6000, false); //Set world time
				} else if (TeamManager.getPlayerTeam(players) == "blue") {
					//blue team spawn
					Location teleportloc = new Location(world, 0.5, 80, -28.5);
					players.teleport(teleportloc); //Teleport player
					players.setPlayerTime(6000, false); //Set world time
				} else {
					Location teleportloc = new Location(world, 0.5, 80, 0.5);
					players.teleport(teleportloc); //Teleport player
					players.setPlayerTime(6000, false); //Set world time
				}
				players.playSound(players.getLocation(), Sound.LEVEL_UP, 1, 10); //play a sound
			}
		}
		
		//Show begging info.
		infoManager.setTitleSlot(miniGameName);
		infoManager.setInfoSlot1(miniGameDescription);
		infoManager.setInfoSlot5(ChatColor.BOLD + "Map created by: " + ChatColor.LIGHT_PURPLE +worldAuthor);
		infoManager.showInfo();
		
		startGamelogic();
	}

	@Override
	public void startGamelogic() {

		//chatManager.debugMessage("starting game logic");
	}
}
