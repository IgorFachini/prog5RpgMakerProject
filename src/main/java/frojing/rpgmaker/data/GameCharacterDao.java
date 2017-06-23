package frojing.rpgmaker.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.GameCharacter;

@Transactional
public interface GameCharacterDao extends CrudRepository<GameCharacter, Long> {

}
