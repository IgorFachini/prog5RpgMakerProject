package frojing.rpgmaker.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import frojing.rpgmaker.service.AttributeService;

@Entity
public class GameCharacter implements Bean {

	public GameCharacter() {
		super();
	}

	public GameCharacter(long id) {
		this();
		this.id = id;
		//attributes = new ArrayList<>();
	}

	public GameCharacter(Player player, Chronicle chronicle) {
		this();
		this.player = player;
		this.chronicle = chronicle;
		
		this.attributes = AttributeService.getAttributes(getChronicle().getGameType());
	}

	@Id
	@GeneratedValue
	private long id;

	// Informações das folhas. Permitir dividir folha em grupos.
	
	//Criar inventário de Combate (Lista de Item)
	//Criar inventário normal
	//Vitalidade (Nome, Penalidade, Estado (Enum))
	//Experiencia
	
	@NotNull
	@ManyToOne
	private Player player;

	@NotNull
	@ManyToOne
	private Chronicle chronicle;
	
	@NotNull
	@OneToMany
	private List<Attribute> attributes;
	
	private int experiencia;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Chronicle getChronicle() {
		return chronicle;
	}

	public void setChronicle(Chronicle chronicle) {
		this.chronicle = chronicle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
}
