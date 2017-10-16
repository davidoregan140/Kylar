package ie.cit.soft8027.kylarsvengeance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;

@SpringBootApplication
public class KylarsVengeanceApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(KylarsVengeanceApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {		

		//returnPlayerInfo();
		playGame();	
	}

	public void playGame() {

		boolean gameOn = true;


		returnPlayerInfo();
		//repositoryExample();
		displayMenu();


	}

	public void repositoryExample() {
		Player player = playerRepository.get(1);
		System.out.println(player.toString());
				
	}
	
		
	//gonna use query06 as an example here
	public void returnPlayerInfo() {

		System.out.println("\n--- Kylar's Vengeance ---\n");
		System.out.println("Printing player details---\n");

		String sql = "SELECT p.id as playerid, p.firstName, p.lastName, p.gender, p.userName, p.balance, e.id as equipmentid, e.type, e.name, e.damageInflicted, e.protectionProvided, e.upgradeLevel " +

				"FROM players p, equipment e, players_equipment pe " +
				"WHERE e.id = pe.equipment_id AND p.id = pe.player_id AND pe.player_id = ?";

		Player player = jdbcTemplate.query(sql, new Object[] { 1 }, 
				new ResultSetExtractor<Player>() {


			@Override
			public Player extractData(ResultSet rs) throws SQLException, DataAccessException {

				;
				Player player = null;
				List<Equipment> equipmentList = new ArrayList<>();

				while (rs.next()) {
					if (player == null) {
						player = new Player();
						player.setId(rs.getInt("id"));
						player.setFirstName(rs.getString("firstName"));
						player.setLastName(rs.getString("lastName"));
						player.setUserName(rs.getString("userName"));
						player.setGender(rs.getString("gender"));												
					}
					Equipment equipment = new Equipment();
					equipment.setId(rs.getInt("id"));
					equipment.setType(rs.getString("type"));
					equipment.setName(rs.getString("name"));
					equipment.setDamageInflicted(rs.getInt("damageInflicted"));
					equipment.setProtectionProvided(rs.getInt("protectionProvided"));
					equipment.setUpgradeLevel(rs.getInt("upgradeLevel"));	
					equipmentList.add(equipment);
				}	

				player.setEquipmentList(equipmentList);

				return player;

			}
		}
				);
		
		System.out.println(player);

	}

	public void displayMenu() {

		System.out.println("\nMain Menu\n");
		System.out.println("1. Finish Round");
		System.out.println("2. Buy new equipment");
		System.out.println("3. Sell equipment");
		System.out.println("4. Upgrade equipment");

	}

}

