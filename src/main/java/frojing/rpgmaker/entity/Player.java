package frojing.rpgmaker.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public Player(String name) {
		super();
		this.name = name;
		this.chronicles = new ArrayList<Chronicle>();
		this.characters = new ArrayList<Character>();
	}

	public Player(String name, List<Chronicle> chronicles, List<Character> characters) {
		super();
		this.name = name;
		this.chronicles = chronicles;
		this.characters = characters;
	}

	private String name;
	private List<Chronicle> chronicles;
	private List<Character> characters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chronicle> getChronicles() {
		return chronicles;
	}

	public List<Character> getCharacters() {
		return characters;
	}

}
