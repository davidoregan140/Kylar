package ie.cit.soft8027.kylarsvengeance.service;

import java.util.List;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;


public interface EquipmentService {
	
	public Equipment get(int id);
	
	public void save(Equipment equipment);
	
	public void remove(Equipment equipment);
	
	public List<Equipment> findAll();

}
