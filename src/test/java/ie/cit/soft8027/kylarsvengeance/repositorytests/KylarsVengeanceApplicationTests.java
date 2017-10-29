package ie.cit.soft8027.kylarsvengeance.repositorytests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import ie.cit.soft8027.kylarsvengeance.DefaultConfig;
import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.domain.PlayerEquipment;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcEquipmentRepository;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcPlayerEquipmentRepository;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcPlayerRepository;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DefaultConfig.class)
@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class KylarsVengeanceApplicationTests {

	@Autowired
	JdbcPlayerRepository repo;
	
	@Autowired
	JdbcEquipmentRepository eqRepo;
	
	@Autowired
	JdbcPlayerEquipmentRepository pEqRepo;
	
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void get() {
		Player p = repo.get(1);
		assertEquals("David", p.getFirstName());	
	}
	
	@Test
	public void getUser() {
		Player p = repo.get(1);
		assertEquals("Sharkbag", p.getUserName());
	}
	
	@Test
	public void findAll() {
		List<Player> players = repo.findAll();
		assertEquals(1, players.size());
	}
	
	@Test
	public void findEquipment() {
		List<Equipment> equipment = eqRepo.findAll();
		assertEquals(8, equipment.size());
	}
	
	@Test
	public void getEquipment() {
		Equipment q = eqRepo.get(5);
		assertEquals("Basic Wooden Shield", q.getName());
	}
		
}
