package frojing.rpgmaker.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.Character;

@Transactional
public interface CharacterDao extends CrudRepository<Character, Long> {

}
