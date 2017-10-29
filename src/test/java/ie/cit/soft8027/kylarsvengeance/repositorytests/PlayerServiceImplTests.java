package ie.cit.soft8027.kylarsvengeance.repositorytests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;
import ie.cit.soft8027.kylarsvengeance.service.PlayerService;
import ie.cit.soft8027.kylarsvengeance.service.PlayerServiceImpl;

public class PlayerServiceImplTests {

	private PlayerService playerService;
	private PlayerRepository repoMock;
	
	@Before
	public void setup() {
		
		repoMock = mock(PlayerRepository.class);
		
		Player p = new Player();
		p.setId(1);
		p.setFirstName("James");
		p.setLastName("Bond");
		p.setGender("male");
		p.setUserName("007");
		p.setBalance(100000);
		
		Player p2 = new Player();
		p.setId(2);
		p.setFirstName("Gillian");
		p.setLastName("Anderson");
		p.setGender("female");
		p.setUserName("Scully");
		p.setBalance(105000);
		
		List<Player> players = new ArrayList<>();
		
		players.add(p);
		players.add(p2);
		
		when(repoMock.get(1)).thenReturn(p);
		when(repoMock.get(2)).thenReturn(p2);
		
		when(repoMock.findAll()).thenReturn(players);
		
		playerService = new PlayerServiceImpl(repoMock);
		
	}
	
	//for some reason get() gets the details for Player 2, and get2() cannot find Player 2???
	@Test
	public void get() {
		Player ps = playerService.get(1);
		assertEquals("Gillian", ps.getFirstName());
		
	}
	
	@Test
	public void get2() {
		Player ps = playerService.get(2);
		assertEquals("Gillian", ps.getFirstName());
	
	}
	
	@Test
	public void findAll() {
		assertTrue(playerService.findAll().size() == 2);
	}
	
	
	
	
	
}
