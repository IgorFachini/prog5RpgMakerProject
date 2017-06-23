package frojing.rpgmaker.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frojing.rpgmaker.entity.Chronicle;
import frojing.rpgmaker.entity.GameCharacter;
import frojing.rpgmaker.entity.GameType;
import frojing.rpgmaker.entity.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class CharacterDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private GameCharacterDao repository;

	@Autowired
	private PlayerDao playerRepository;

	@Autowired
	private ChronicleDao chronicleRepository;

	@Test
	public void test() throws Exception {
		Player player = new Player("Player");
		this.entityManager.persist(player);

		Chronicle chronicle = new Chronicle("Chronicle", GameType.WORLD_OF_DARKNESS, player);
		this.entityManager.persist(chronicle);

		GameCharacter c = new GameCharacter(player, chronicle);
		this.entityManager.persist(c);
		GameCharacter character = this.repository.findOne(c.getId());
		assertThat(character.getPlayer().getName()).isEqualTo("Player");
		assertThat(character.getChronicle().getGameType()).isEqualTo(GameType.WORLD_OF_DARKNESS);
	}

}
