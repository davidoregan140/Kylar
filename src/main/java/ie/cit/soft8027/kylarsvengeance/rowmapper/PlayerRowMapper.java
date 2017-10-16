package ie.cit.soft8027.kylarsvengeance.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.soft8027.kylarsvengeance.domain.Player;

public class PlayerRowMapper implements RowMapper<Player>{

	@Override
	public Player mapRow(ResultSet rs, int index) throws SQLException {		
		Player player = new Player();
		
		player.setId(rs.getInt("id"));
		player.setFirstName(rs.getString("firstName"));
		player.setLastName(rs.getString("lastName"));
		player.setGender(rs.getString("gender"));
		player.setUserName(rs.getString("userName"));
		player.setBalance(rs.getDouble("balance"));
				
		return player;
	}

}
