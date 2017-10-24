package ie.cit.soft8027.kylarsvengeance.domain;

public class PlayerEquipment {

	private int playerId;
	
	private int equipmentId;
	
	public PlayerEquipment() {
		
	}

	
	
	public PlayerEquipment(int playerId, int equipmentId) {
		super();
		this.playerId = playerId;
		this.equipmentId = equipmentId;
	}



	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	
}
