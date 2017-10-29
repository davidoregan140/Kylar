package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {

	PlayerRepository playerRepository;
	
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
		playerRepository.remove(player);
		
	}

	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	
}
