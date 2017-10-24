package ie.cit.soft8027.kylarsvengeance.repository;

import java.util.List;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.PlayerEquipment;

public interface PlayerEquipmentRepository {

	public PlayerEquipmentRepository get(int id);
	
	public void add(PlayerEquipment playerEquipment);
	
	public void save(PlayerEquipment playerEquipment);
	
	public void remove(PlayerEquipment playerEquipment);
	
	public List<Equipment> findAll();
}
