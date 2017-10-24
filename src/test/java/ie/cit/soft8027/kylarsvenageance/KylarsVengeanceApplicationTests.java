package ie.cit.soft8027.kylarsvenageance;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcPlayerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = DefaultConfig.class)
@SpringBootTest
//@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)


public class KylarsVengeanceApplicationTests {

	@Autowired
	JdbcPlayerRepository repo;
	
	@Test
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void get() {
		Player p = repo.get(1);
		assertEquals("Sharkbag", p.getUserName());
		
	}
	
}
