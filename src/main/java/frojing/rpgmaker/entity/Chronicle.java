package frojing.rpgmaker.entity;

import java.util.ArrayList;
import java.util.List;

public class Chronicle {

	public Chronicle(String name, GameType gameType, Player gameMaster) {
		super();
		this.name = name;
		this.players = new ArrayList<Player>();
		this.gameType = gameType;
		this.gameMaster = gameMaster;
	}
	
	public Chronicle(String name, List<Player> players, GameType gameType, Player gameMaster) {
		super();
		this.name = name;
		this.players = players;
		this.gameType = gameType;
		this.gameMaster = gameMaster;
	}

	private String name;
	private List<Player> players;
	private GameType gameType; 
	private Player gameMaster;
	
	public void getCharacterSheet(){
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public Player getGameMaster() {
		return gameMaster;
	}

	public void setGameMaster(Player gameMaster) {
		this.gameMaster = gameMaster;
	}
	
	
	
}
