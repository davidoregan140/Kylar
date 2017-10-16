package ie.cit.soft8027.kylarsvengeance.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;

public class EquipmentRowMapper implements RowMapper<Equipment> {

	@Override
	public Equipment mapRow(ResultSet rs, int index) throws SQLException {
		Equipment equipment = new Equipment();
		equipment.setId(rs.getInt("id"));
		equipment.setType(rs.getString("type"));
		equipment.setName(rs.getString("name"));
		equipment.setDamageInflicted(rs.getInt("damageInflicted"));
		equipment.setProtectionProvided(rs.getInt("protectionProvided"));
		equipment.setUpgradeLevel(rs.getInt("upgradeLevel"));
		
		return equipment;
	}

	
	
}
