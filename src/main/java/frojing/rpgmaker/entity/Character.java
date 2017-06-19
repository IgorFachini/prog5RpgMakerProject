package frojing.rpgmaker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Character implements Bean {

	public Character() {
		super();
	}

	public Character(long id) {
		this();
		this.id = id;
	}

	public Character(Player player, frojing.rpgmaker.entity.Chronicle chronicle) {
		this();
		this.player = player;
		this.chronicle = chronicle;
	}

	@Id
	@GeneratedValue
	private long id;

	// Informacoes das folhas. Permitir dividir folha em grupos.
	@NotNull
	@ManyToOne
	private Player player;

	@NotNull
	@ManyToOne
	private Chronicle chronicle;

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

}
