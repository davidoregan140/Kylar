package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.domain.PlayerEquipment;
import ie.cit.soft8027.kylarsvengeance.rowmapper.PlayerEquipmentRowMapper;

@Repository
public class JdbcPlayerEquipmentRepository implements PlayerEquipmentRepository{

	private JdbcTemplate jdbcTemplate;
	
	private PlayerEquipment playerEquipment;
	
	@Autowired
	public JdbcPlayerEquipmentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public void save(PlayerEquipment playerEquipment) {
		if (playerEquipment.getPlayerId() != 0) {
			update(playerEquipment);
		} else {
			add(playerEquipment);
			
		}
	}

	private void update(PlayerEquipment playerEquipment) {
		String sql = "UPDATE players_equipment SET player_id = ?, equipment_id = ? WHERE player_id = ?";
		jdbcTemplate.update(sql, new Object[] { playerEquipment.getPlayerId(), playerEquipment.getEquipmentId() });
	}
	

	@Override
	public List<PlayerEquipment> findAll() {
		String sql = "SELECT * FROM players_equipment";
		return jdbcTemplate.query(sql, new PlayerEquipmentRowMapper());
	}

	@Override
	public void add(PlayerEquipment playerEquipment) {
		String sql = "INSERT INTO players_equipment (player_id, equipment_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { playerEquipment.getPlayerId(), playerEquipment.getEquipmentId() });
		
	}


	@Override
	public PlayerEquipmentRepository get(int id) {
		return null;
	}



	@Override
	public void remove(PlayerEquipment playerEquipment) {
		String sql = "DELETE FROM players_equipment WHERE equipment_id = ?";
		jdbcTemplate.update(sql, new Object[] { playerEquipment.getEquipmentId() });
		
	}


	@Override
	public List<PlayerEquipment> getEquipmentId() {
		String sql = "SELECT equipment_id FROM players_equipment";
		return jdbcTemplate.query(sql, new PlayerEquipmentRowMapper());
	}

	
}
