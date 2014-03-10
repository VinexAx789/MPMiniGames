package com.minepile.mpmg.util;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.minepile.mpmg.MPMGMain;

public class GameManager {
	
	//Setup game variables
	private int gameCount = 0; //Count number of games played since last server restart.
	private boolean gameActive = false; //Set false to start server in lobby.
	private World world = Bukkit.getWorld("world"); //set default word. (world = lobby)
	private int timeCount = 60;
	
	
	//Load Objects
	private static MPMGMain plugin = MPMGMain.plugin;
	private ChatManager chatManager = new ChatManager();
	
	//Lets start the core logic of our game
	public void startGameManager() {
		//Lobby Loop
		if (gameActive == false) {
			chatManager.debugMessage("Starting lobby loop");
			//Load lobby
			//Load lobby world
			//wait for players
			//start count down if enough players join
			/*
			if ( >= 1) {
				//count down to 1 and start the game
				countDownManager.startCountDown();
			}
			*/
			startCountDown();
			//set gameActive True
		}
		
		//Game Loop 
		if (gameActive == true) {
			//Load game
			//load game world
			//spawn players
			//game ends
			//set gameActive false
			gameCount++; //Increment the amount of games played.
		}

	}
	
	//Countdown
	public void startCountDown() {
		//If timeCount is not 60 when this method is called,
		//lets reset it, so it is. This is a 60 second countdown.
		if(timeCount != 60) {
			timeCount = 60;
		}
		
		//Lets start a repeating task
		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			@Override
			public void run() {
				chatManager.colorCountDown(timeCount);
				timeCount--;
				if (timeCount < 0) {
					timeCount = 60;
				}
			}
			
		}, 0, 20); //(20 ticks = 1 second)
	}
	
	//Lobby Loop
	public void lobbyTaskLoop() {		
		//Lets start a repeating task
		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			@Override
			public void run() {
				//do something
			}
		}, 0, 20); //(20 ticks = 1 second)
	}
	
	//Game Loop
	public void gameTaskLoop() {		
		//Lets start a repeating task
		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			@Override
			public void run() {
				//do something
			}
		}, 0, 20); //(20 ticks = 1 second)
	}
	
	//Getters and Setters
	public int getGameCount() {
		return gameCount;
	}
	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}
	public boolean isGameActive() {
		return gameActive;
	}
	public void setGameActive(boolean gameActive) {
		this.gameActive = gameActive;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	
}