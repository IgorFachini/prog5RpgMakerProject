package frojing.rpgmaker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CharacterSheet implements Bean {

	public CharacterSheet() {
		super();
	}

	public CharacterSheet(long id) {
		this();
		this.id = id;
	}

	public CharacterSheet(GameType gameType, String sheetLocation) {
		this();
		this.gameType = gameType;
		this.sheetLocation = sheetLocation;
	}

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private GameType gameType;

	@NotNull
	private String sheetLocation;

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getSheetLocation() {
		return sheetLocation;
	}

	public void setSheetLocation(String sheetLocation) {
		this.sheetLocation = sheetLocation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
