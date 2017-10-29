package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	JdbcTemplate jdbcTemplate;
	
	EquipmentRepository equipmentRepository;
	
	@Autowired
	public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
		super();
		this.equipmentRepository = equipmentRepository;
	}
	
	@Override
	public Equipment get(int id) {
		return equipmentRepository.get(id);
	}


	@Override
	public void save(Equipment equipment) {
		equipmentRepository.save(equipment);		
	}

	@Override
	public void remove(Equipment equipment) {
		String sql = "DELETE FROM equipment WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { equipment.getId() } );		
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentRepository.findAll();
	}

	
}
