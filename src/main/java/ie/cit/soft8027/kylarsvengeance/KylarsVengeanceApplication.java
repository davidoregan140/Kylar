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
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.domain.Player;
import ie.cit.soft8027.kylarsvengeance.domain.PlayerEquipment;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcEquipmentRepository;
import ie.cit.soft8027.kylarsvengeance.repository.JdbcPlayerEquipmentRepository;
import ie.cit.soft8027.kylarsvengeance.repository.PlayerRepository;
import ie.cit.soft8027.kylarsvengeance.repository.EquipmentRepository;

@SpringBootApplication
//@Import(DefaultConfig.class)
public class KylarsVengeanceApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	JdbcEquipmentRepository jdbcEquipmentRepository;
	
	@Autowired
	JdbcPlayerEquipmentRepository jdbcPlayerEquipmentRepository;
	
	Equipment equipment;
	
	Scanner reader = new Scanner(System.in);

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

		System.out.println("\n--- Kylar's Vengeance ---\n"); //maybe have this at top all time?
		System.out.println("Printing player details---\n");

		String sql = "SELECT p.id as playerid, p.firstName, p.lastName, p.gender, p.userName, p.balance, "
				+ "e.id as equipmentid, e.type, e.name, e.damageInflicted, e.protectionProvided, e.upgradeLevel, e.price " +

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
						player.setBalance(rs.getInt("balance"));
					}
					Equipment equipment = new Equipment();
					equipment.setId(rs.getInt("id"));
					equipment.setType(rs.getString("type"));
					equipment.setName(rs.getString("name"));
					equipment.setDamageInflicted(rs.getInt("damageInflicted"));
					equipment.setProtectionProvided(rs.getInt("protectionProvided"));
					equipment.setUpgradeLevel(rs.getInt("upgradeLevel"));	
					equipment.setPrice(rs.getInt("price"));	
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

		
		char choice;
		boolean finish = false;
	
	do 
		{
		System.out.println();
		System.out.println("\nMain Menu\n");
		System.out.println("1. Buy new equipment");
		System.out.println("2. Sell equipment");
		System.out.println("3. Upgrade equipment");
		System.out.println("4. Finish Round");
		System.out.println();
		
		System.out.println("Please enter your choice: ");
		choice = reader.next().charAt(0);
		
		System.out.println();
		
		switch (choice)
		{
		case '1' : //for buying new equipment
			
			buyEquipment();
			takePayment();
			returnPlayerInfo();
			
			break;
			
		case '2' : //for selling equipment
			
			sellEquipment();
			returnPlayerInfo();
			break;
			
		case '3' :
			System.out.println("3. Sell equipment");
			break;
			
		case '4' :  finish = true;
			System.out.println("4. Finish Round");
			break;
			default : System.out.println("Wrooooonnnnnnnng");
			break;
			
		}
		
		}
	while (choice != '4');
	
	System.out.println("Thank you for playing." + "\n" + "Goodbye :) ");
	reader.close();
	
	
	}
	
	
	public void buyEquipment() {
				
		System.out.println();
		System.out.println("1. Buy new equipment");
		System.out.println("Enter id number of the piece of equipment you wish to buy:\n");
		System.out.println("Items available to buy: ");
		
		//maybe instead of hardcoded I could use an array filled with 
		//the equipment table and populate it with a loop?
		System.out.println("1. Sword - Type: Up-Close Weapon");
		System.out.println("2. Crossbow - Type: Distance Weapon");
		System.out.println("3. Dagger - Type: Up-Close Weapon");
		System.out.println("4. Spear - Type: Distance Weapon");
		System.out.println("5. Basic Wooden Shield - Type: Shield");
		System.out.println("6. Heavy Wooden Shield - Type: Shield");
		System.out.println("7. Chain Mail - Type: Armour");
		System.out.println("8. Plate Armour - Type: Armour");
		
		int eqChoice = reader.nextInt();
		System.out.println("You have picked equipment id: " + eqChoice);
		
		//method to add to player_equipment table (1, eqChoice)
		//the (1, being player 1, and the eqChoice the id of the equipment to be added.
		
		Player player = playerRepository.get(1);
		
		PlayerEquipment playerEquipment = new PlayerEquipment();
		playerEquipment.setPlayerId(1);
		playerEquipment.setEquipmentId(eqChoice);
		
		jdbcPlayerEquipmentRepository.add(playerEquipment);
	
		/*this only works for setting balance of the player object, not of the table player
		At the moment I have to hard code the price of the piece of equipment so it takes it away from the total
		balance*/
		
		player.setBalance(player.getBalance()-250);
		System.out.println("balance: " + player.getBalance());
			
		playerRepository.save(player);			
		}
	
	public void sellEquipment() {
		
		System.out.println();
		System.out.println("1. Sell equipment");
		System.out.println("Enter id number of the piece of equipment you wish to sell:\n");
		//System.out.println("Items available to sell: ");
		
		//maybe instead of hardcoded I could use an array filled with 
		//the equipment table and populate it with a loop?
		System.out.println("1. Sword - Type: Up-Close Weapon");
		System.out.println("2. Crossbow - Type: Distance Weapon");
		System.out.println("3. Dagger - Type: Up-Close Weapon");
		System.out.println("4. Spear - Type: Distance Weapon");
		System.out.println("5. Basic Wooden Shield - Type: Shield");
		System.out.println("6. Heavy Wooden Shield - Type: Shield");
		System.out.println("7. Chain Mail - Type: Armour");
		System.out.println("8. Plate Armour - Type: Armour");
		
		int eqChoice = reader.nextInt();
		System.out.println("You have picked equipment id: " + eqChoice);
		
		Player player = playerRepository.get(1);
		
		PlayerEquipment playerEquipment = new PlayerEquipment();
		playerEquipment.setPlayerId(1);
		playerEquipment.setEquipmentId(eqChoice);
		
		jdbcPlayerEquipmentRepository.remove(playerEquipment);
		
		player.setBalance(player.getBalance()+250);
		System.out.println("balance: " + player.getBalance());
			
		playerRepository.save(player);
		
	}
	
	
	//this will decrease the player's balance depending on what they have bought
	public void takePayment() {
		
		System.out.println("Balance deducted");
		
	}
	
	

}

