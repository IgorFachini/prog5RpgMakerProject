package frojing.rpgmaker.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.Player;

@Transactional
public interface PlayerDao extends CrudRepository<Player, Long> {

}
