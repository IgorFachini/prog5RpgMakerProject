package frojing.rpgmaker.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.Chronicle;
import frojing.rpgmaker.entity.Player;

@Transactional
public interface ChronicleDao extends CrudRepository<Chronicle, Long> {

	public List<Chronicle> findByPlayersContains(Player player);
	public List<Chronicle> findByGameMaster(Player gameMaster);
	
}
