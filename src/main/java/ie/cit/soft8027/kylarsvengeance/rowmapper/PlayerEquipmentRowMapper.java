package ie.cit.soft8027.kylarsvengeance.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.soft8027.kylarsvengeance.domain.PlayerEquipment;

public class PlayerEquipmentRowMapper implements RowMapper<PlayerEquipment> {

	@Override
	public PlayerEquipment mapRow(ResultSet rs, int index) throws SQLException {
		PlayerEquipment playerEquipment = new PlayerEquipment();
		playerEquipment.setPlayerId(rs.getInt("player_id"));
		playerEquipment.setEquipmentId(rs.getInt("equipment_id"));
		
		return playerEquipment;
	}

	
}
