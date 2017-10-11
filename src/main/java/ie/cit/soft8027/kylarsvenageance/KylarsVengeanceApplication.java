package ie.cit.soft8027.kylarsvenageance;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class KylarsVengeanceApplication implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(KylarsVengeanceApplication.class, args);
}



	@Override
	public void run(String... arg0) throws Exception {		
		
		returnPlayerInfo();
	
		
		
		
	}
	
	
	
	
	public void returnPlayerInfo() {
		
		System.out.println("\n--- Kylar's Vengeance ---\n"); //maybe have this at top all time?
		System.out.println("Printing player details---\n");
		
		String sql = "SELECT * FROM players";
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
		
		for (Map<String, Object> row : resultSet) {
			System.out.println("Player: " + row.get("userName"));
			System.out.println("ID: " + row.get("id"));
			System.out.println("Balance: " + row.get("balance") + " Kubits");
			System.out.println("Equipment: " + "gonna included the contents of the player's equipment array here");
			
			
		}
		
		
	}
	
	
}
//	System.out.println("\n--- Kylar's Vengeance ---\n");
//	System.out.println("Player: Jedi Jones\n");
//	System.out.println("Balance: 824 Kubits\n");
//	System.out.println("Equipment: Mace (level 3), Crossbow (level 1), "
//			+ "Armour (level 5), Shield (level 4)\n");
//	System.out.println("Main Menu\n");
//	System.out.println("1.	Finish Round\n");
//	System.out.println("2.	Buy new equipment\n");
//	System.out.println("3.	Sell equipment\n");
//	System.out.println("4.	Upgrade equipment\n");
