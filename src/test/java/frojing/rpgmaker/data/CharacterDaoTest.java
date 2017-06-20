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

import frojing.rpgmaker.entity.Character;
import frojing.rpgmaker.entity.Chronicle;
import frojing.rpgmaker.entity.GameType;
import frojing.rpgmaker.entity.Player;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class CharacterDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CharacterDao repository;

	@Test
	public void test() throws Exception {
		Player player = new Player("Player");
		Chronicle chronicle = new Chronicle("Chronicle", GameType.WORLD_OF_DARKNESS, player);
		Character c = new Character(player, chronicle);
		this.entityManager.persist(c);
		Character character = this.repository.findOne(c.getId());
		assertThat(character.getPlayer().getName()).isEqualTo("Player");
		assertThat(character.getChronicle().getGameType()).isEqualTo(GameType.WORLD_OF_DARKNESS);
	}

}
