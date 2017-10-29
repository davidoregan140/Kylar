package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	PlayerRepository playerRepository;

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	
	@Override
	public Player get(int id) {
		return playerRepository.get(id);
	}


	@Override
	public void save(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void remove(Player player) {
		String sql = "DELETE FROM players WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { player.getId() } );		
	}

	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	
}
