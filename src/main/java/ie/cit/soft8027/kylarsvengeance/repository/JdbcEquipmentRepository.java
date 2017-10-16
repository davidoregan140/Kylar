package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.rowmapper.EquipmentRowMapper;

public class JdbcEquipmentRepository implements EquipmentRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcEquipmentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Equipment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

