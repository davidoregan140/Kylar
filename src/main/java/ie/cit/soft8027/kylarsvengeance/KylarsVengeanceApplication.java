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


@Import(DefaultConfig.class)
public class KylarsVengeanceApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	EquipmentRepository 	equipmentRepository;

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

		playGame();	
	}


	public void playGame() {

		returnPlayerInfo();
		displayMenu();

	}

	public void repositoryExample() {
		Player player = playerRepository.get(1);
		System.out.println(player.toString());

	}


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
	
				returnPlayerInfo();
			
				break;

			case '2' : //for selling equipment

				sellEquipment();
				returnPlayerInfo();

				break;

			case '3' :

				upgradeEquipment();
				returnPlayerInfo();

				break;

			case '4' :  
				
			System.out.println("4. Finish Round");
			
			break;
			
			default : System.out.println("Sorry, " + choice + " is an invalid selection, please choose from the available options");
			
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

		//to populate the ID list
		List<PlayerEquipment> playerEquipmentList = jdbcPlayerEquipmentRepository.findAll();

		ArrayList<Integer> idList = new ArrayList<Integer>();
		
		for (PlayerEquipment e : playerEquipmentList) {
			idList.add(e.getEquipmentId()); //this should add just the id of each piece of equipment the player has
		}
		
		
		//to populate the eq itself
		List<Equipment> equipmentList = jdbcEquipmentRepository.findAll();
		
		for (Equipment eq : equipmentList) {
		System.out.println(eq.toString());
		}

		int eqChoice = reader.nextInt();
		
//		for (Integer i : idList) {
//			System.out.println("Already have: " + i);
//		}

		//if the equipment chosen is already in the player's equipment list:
		if (idList.contains(eqChoice)) {
			System.out.println("You already have a " + jdbcEquipmentRepository.get(eqChoice).getName() + ", please try again");
			
			buyEquipment();
		}

		else if (eqChoice <= equipmentList.size()) {


			//method to add to player_equipment table (1, eqChoice)
			//the (1, being player 1, and the eqChoice the id of the equipment to be added.

			Player player = playerRepository.get(1);

			PlayerEquipment playerEquipment = new PlayerEquipment();
			playerEquipment.setPlayerId(1);
			playerEquipment.setEquipmentId(eqChoice);

			jdbcPlayerEquipmentRepository.add(playerEquipment); // this works - put in 4 and you get a Spear

			/*this only works for setting balance of the player object, not of the table player
		At the moment I have to hard code the price of the piece of equipment so it takes it away from the total
		balance*/

			Equipment equipmentBuy = jdbcEquipmentRepository.get(eqChoice);

			System.out.println("\nYou have purchased a " + equipmentBuy.getName());
			int priceToDeduct = equipmentBuy.getPrice();


			player.setBalance(player.getBalance()-priceToDeduct);
			System.out.println("\nBalance after deducting " + priceToDeduct + " Kubits is " + player.getBalance() + " Kubits.");

			playerRepository.save(player);			
		
		}
		
		else {
			System.out.println("No equipment with this ID, please try again");
			buyEquipment();
		}

	}

	

	public void sellEquipment() {

		System.out.println();
		System.out.println("2. Sell equipment");
		System.out.println("Enter id number of the piece of equipment you wish to sell:\n");

		List<Equipment> equipment = jdbcEquipmentRepository.findAll();

		for (Equipment e : equipment) {
			System.out.println(e.toString());
		}
		
		int eqChoice = reader.nextInt();
		
		//to validate player entry:
		List<PlayerEquipment> playerEquipmentList = jdbcPlayerEquipmentRepository.findAll();

		ArrayList<Integer> idList = new ArrayList<Integer>();
		
		for (PlayerEquipment e : playerEquipmentList) {
			idList.add(e.getEquipmentId()); //this should add just the id of each piece of equipment the player has
		}

		if (!idList.contains(eqChoice)) {
			System.out.println("You don't own " + jdbcEquipmentRepository.get(eqChoice).getName() + ", please try again");
			
			sellEquipment();
		}

		else if (idList.contains(eqChoice)) {
		
		
		Player player = playerRepository.get(1);
		


		
		PlayerEquipment playerEquipment = new PlayerEquipment();
		playerEquipment.setPlayerId(1);
		playerEquipment.setEquipmentId(eqChoice);

		jdbcPlayerEquipmentRepository.remove(playerEquipment);
		
		Equipment equipmentSell = jdbcEquipmentRepository.get(eqChoice);

		System.out.println("You have sold your " + equipmentSell.getName());
		
		int priceToReceive = equipmentSell.getPrice()-50;
		
		player.setBalance(player.getBalance()+priceToReceive);
		System.out.println("Balance after sale: " + player.getBalance() + "Kubits.");

		playerRepository.save(player);

		}
	}



	public void upgradeEquipment() {
		System.out.println("3. Upgrade equipment");
		System.out.println("Enter id number of the piece of equipment you wish to upgrade:\n");

		List<Equipment> equipmentList = equipmentRepository.findAll();

		for (Equipment e : equipmentList) {
			System.out.println(e.toString());
		}

		int eqChoice = reader.nextInt();
		Equipment e = jdbcEquipmentRepository.get(eqChoice);
		System.out.println("You have upgraded your " + e.getName());

		Player player = playerRepository.get(1);

		
		e.setDamageInflicted(e.getDamageInflicted() + 15);
		e.setProtectionProvided(e.getProtectionProvided() + 15);
		e.setUpgradeLevel(e.getUpgradeLevel() + 1);
		
	
		jdbcEquipmentRepository.update(e);
		playerRepository.save(player);


	}


}

