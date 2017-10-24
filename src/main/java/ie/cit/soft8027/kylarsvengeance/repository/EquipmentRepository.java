package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;

public interface EquipmentRepository {

	public Equipment get(int id);
	
	public void add(int playerId, int equipmentId);
	
	public void save(Equipment equipment);
	
	public void remove(Equipment equipment);
	
	public List<Equipment> findAll();
	
}

