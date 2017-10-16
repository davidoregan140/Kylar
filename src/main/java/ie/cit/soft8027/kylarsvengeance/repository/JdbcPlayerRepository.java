package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.rowmapper.PlayerRowMapper;

@Repository
public class JdbcPlayerRepository implements PlayerRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcPlayerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Player get(int id) {
		String sql = "SELECT * FROM players WHERE id = ?";
		Player player = jdbcTemplate.queryForObject(sql, new Object[] { 1 }, 
				new PlayerRowMapper());
		return player;
	}

	@Override
	public void save(Player player) {
		if (player.getId() != 0) {
			update(player);
		} else {
			add(player);
		}
		
	}

	private void add(Player player) {
		String sql = "INSERT INTO artists (fullName, gender) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] { player.getUserName(), player.getGender()} );
	}
	
	private void update(Player player) {
		String sql = "UPDATE artists SET fullName = ?, gender = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { player.getUserName(),
			player.getGender(), player.getId()} );
	}
	
	@Override
	public void remove(Player player) {
		String sql = "DELETE FROM players WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { player.getId() } );		
	}

	@Override
	public List<Player> findAll() {
		String sql = "SELECT * FROM players";
		return jdbcTemplate.query(sql, new PlayerRowMapper());
	}

	
}
