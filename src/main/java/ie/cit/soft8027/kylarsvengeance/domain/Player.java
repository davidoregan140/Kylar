package ie.cit.soft8027.kylarsvengeance.domain;

import java.util.Collections;
import java.util.List;

import ie.cit.soft8027.kylarsvengeance.repository.EquipmentRepository;

public class Player {
	
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String gender;
	
	private String userName;
	
	private int balance;

	private List<Equipment> equipmentList;
	
	EquipmentRepository equipmentRepository;

	//constructor
	public Player() {
		
	}
	
	
	
	public Player(int id, String firstName, String lastName, String gender, String userName, int balance,
			List<Equipment> equipmentList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.userName = userName;
		this.balance = balance;
		this.equipmentList = equipmentList;
	}



	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}


	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getUserName() {
		return userName;
	}

	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		String out = "Player ID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGender: " + gender
				+ "\nUsername: " + userName + "\nBalance: " + balance + " Kubits" + "\nCurrent Equipment: \n";
		
		
			for (Equipment e : equipmentList) {
				out += e.toString() + "\n";
			}
			
		return out;
		
	}


}
