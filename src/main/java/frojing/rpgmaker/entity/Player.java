package frojing.rpgmaker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Player implements Bean {

	public Player(){
		super();
		this.chronicles = new ArrayList<Chronicle>();
		this.characters = new ArrayList<Character>();
	}
	
	public Player(long id) {
		this();
		this.id = id;
	}

	public Player(String name) {
		this();
		this.name = name;
	}

	public Player(String name, List<Chronicle> chronicles, List<Character> characters) {
		super();
		this.name = name;
		this.chronicles = chronicles;
		this.characters = characters;
	}

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	@NotNull
	@ManyToMany(mappedBy = "players", cascade = CascadeType.ALL)
	private List<Chronicle> chronicles;

	@NotNull
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
