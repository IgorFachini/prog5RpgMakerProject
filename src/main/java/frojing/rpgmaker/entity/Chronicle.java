package frojing.rpgmaker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Chronicle implements Bean {

	public Chronicle(){
		super();
	}
	
	public Chronicle(long id) {
		this();
		this.id = id;
	}

	public Chronicle(String name, GameType gameType, Player gameMaster) {
		this();
		this.name = name;
		this.players = new ArrayList<Player>();
		this.gameType = gameType;
		this.gameMaster = gameMaster;
	}

	public Chronicle(String name, List<Player> players, GameType gameType, Player gameMaster) {
		this();
		this.name = name;
		this.players = players;
		this.gameType = gameType;
		this.gameMaster = gameMaster;
	}

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;
	
	@NotNull
	@ManyToMany
	private List<Player> players;
	
	@NotNull
	private GameType gameType;
	
	@NotNull
	@OneToOne
	private Player gameMaster;

	public void getCharacterSheet() {

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
