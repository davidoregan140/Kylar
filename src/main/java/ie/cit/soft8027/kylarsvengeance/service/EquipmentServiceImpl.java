package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.repository.EquipmentRepository;

public class EquipmentServiceImpl implements EquipmentService {

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
		equipmentRepository.remove(equipment);
		
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentRepository.findAll();
	}

	
}
