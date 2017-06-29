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
		this.characters = new ArrayList<GameCharacter>();
	}
	
	public Player(long id) {
		this();
		this.id = id;
	}

	public Player(String name) {
		this();
		this.name = name;
	}

	public Player(String name, List<Chronicle> chronicles, List<GameCharacter> characters) {
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
	private List<GameCharacter> characters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chronicle> getChronicles() {
		return chronicles;
	}

	public List<GameCharacter> getCharacters() {
		return characters;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setChronicles(List<Chronicle> chronicles) {
		this.chronicles = chronicles;
	}

	public void setCharacters(List<GameCharacter> characters) {
		this.characters = characters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + ((chronicles == null) ? 0 : chronicles.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (chronicles == null) {
			if (other.chronicles != null)
				return false;
		} else if (!chronicles.equals(other.chronicles))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
