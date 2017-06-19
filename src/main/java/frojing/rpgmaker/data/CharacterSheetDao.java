package frojing.rpgmaker.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.CharacterSheet;

@Transactional
public interface CharacterSheetDao extends CrudRepository<CharacterSheet, Long> {

}
