package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.rowmapper.EquipmentRowMapper;

@Repository
public class JdbcEquipmentRepository implements EquipmentRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcEquipmentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public JdbcEquipmentRepository() {
		
	}
	
	@Override
	public Equipment get(int id) {
		String sql = "SELECT * FROM equipment WHERE id = ?";
		Equipment equipment = jdbcTemplate.queryForObject(sql, new Object[] { 1 }, 
				new EquipmentRowMapper());
		return equipment;
	}

	@Override
	public void save(Equipment equipment) {
		if (equipment.getId() != 0) {
			update(equipment);
		} else {
			add(equipment);
		}
		
	}
	
	public void add(Equipment equipment) {
		Player player = new Player();
		//Equipment equipment = new Equipment();
		String sql = "INSERT INTO players_equipment (player_id, equipment_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { player.getId(), equipment.getId()} );
		
	}
	
	private void update(Equipment equipment) {
		String sql = "UPDATE equipment SET id = ?, type = ?, name = ?, damageInflicted = ?, "
				+ "protectionProvided = ?, upgradeLevel = ?, price = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { equipment.getId(), equipment.getType(), equipment.getName(), 
				equipment.getDamageInflicted(), equipment.getProtectionProvided(), 
				equipment.getUpgradeLevel(), equipment.getPrice() });
	}
	

	@Override
	public void remove(Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Equipment> findAll() {
		String sql = "SELECT * FORM equipment";
		return jdbcTemplate.query(sql, new EquipmentRowMapper());
	}


	@Override
	public void add(int playerId, int equipmentId) {
		// TODO Auto-generated method stub
		
	}

	
	
}

