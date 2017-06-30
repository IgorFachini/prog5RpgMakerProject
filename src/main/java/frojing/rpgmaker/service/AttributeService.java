package frojing.rpgmaker.service;

import java.util.ArrayList;
import java.util.List;

import frojing.rpgmaker.entity.Attribute;
import frojing.rpgmaker.entity.GameType;

public class AttributeService {

	private static List<Attribute> worldOfDarknessAttributes;
	private static List<Attribute> dungeonsAndDragonsAttributes;

	static {
		worldOfDarknessAttributes = new ArrayList<>();

		// Atributos
		// Fisicos
		worldOfDarknessAttributes.add(new Attribute("Força", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Destreza", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Vigor", 1, 10, 5));

		// Socias
		worldOfDarknessAttributes.add(new Attribute("Carisma", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Manipulação", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Aparência", 1, 10, 5));

		// Mentais
		worldOfDarknessAttributes.add(new Attribute("Percepção", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Inteligência", 1, 10, 5));
		worldOfDarknessAttributes.add(new Attribute("Raciocínio", 1, 10, 5));

		// Habilidades
		// Talentos

		// Perícias

		// Conhecimento

		// Vantagens
		// Outras Caracteristicas

		// Antecedentes

		// Qualidades e Defeitos

		// Fé

		// Virtudes

		// Antecedentes

		// Humanidade

		// Força de Vontade

		dungeonsAndDragonsAttributes = new ArrayList<>();

	}

	public static int calculatePrice(Attribute attribute) {
		int multiplier = attribute.getCurrentValue() > 5 ? attribute.getSpecialMultiplier()
				: attribute.getPriceMultiplier();
		return attribute.getCurrentValue() * multiplier;
	}

	public static List<Attribute> getAttributes(GameType gameType) {
		List<Attribute> attributes = null;

		if (GameType.WORLD_OF_DARKNESS.equals(gameType)) {
			attributes = worldOfDarknessAttributes;
		} else if (GameType.DUNGEONS_AND_DRAGONS.equals(gameType)) {
			attributes = dungeonsAndDragonsAttributes;
		}

		return attributes;
	}

}
