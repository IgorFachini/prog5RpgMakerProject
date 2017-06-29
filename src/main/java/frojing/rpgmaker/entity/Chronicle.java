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

	//@NotNull
	@ManyToMany
	private List<Player> players;

	@NotNull
	private GameType gameType;

	@NotNull
	@OneToOne
	private Player gameMaster;

	public void getCharacterSheet() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setPlayers(List<Player> players) {
		this.players = players;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameMaster == null) ? 0 : gameMaster.hashCode());
		result = prime * result + ((gameType == null) ? 0 : gameType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chronicle other = (Chronicle) obj;
		if (gameMaster == null) {
			if (other.gameMaster != null)
				return false;
		} else if (!gameMaster.equals(other.gameMaster))
			return false;
		if (gameType != other.gameType)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}

	
	
	

}
