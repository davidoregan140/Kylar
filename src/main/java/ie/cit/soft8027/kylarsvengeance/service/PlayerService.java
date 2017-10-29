package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import ie.cit.soft8027.kylarsvengeance.domain.Player;

public interface PlayerService {

	public Player get(int id);
	
	public void save(Player player);
	
	public void remove(Player player);
	
	public List<Player> findAll();
}
