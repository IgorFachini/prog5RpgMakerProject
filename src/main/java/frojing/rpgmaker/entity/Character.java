package frojing.rpgmaker.entity;

public class Character {

	public Character(Player player, frojing.rpgmaker.entity.Chronicle chronicle) {
		super();
		this.player = player;
		this.chronicle = chronicle;
	}

	// Informacoes das folhas. Permitir dividir folha em grupos.
	private Player player;
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

}
