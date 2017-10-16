package ie.cit.soft8027.kylarsvengeance.domain;

import java.util.Collections;
import java.util.List;

public class Player {
	
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String gender;
	
	private String userName;
	
	private double balance;

	private List<Equipment> equipmentList;

	//constructor
	public Player() {
		equipmentList = Collections.<Equipment>emptyList();
	}
	
	
	
	public Player(int id, String firstName, String lastName, String gender, String userName, double balance,
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

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		String out = "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", userName=" + userName + ", balance=" + balance + ", equipmentList=[";
		
			for (Equipment e : equipmentList) {
				out += e.toString() + ",";
			}
			out += "]]";
		return out;
		
	}


}
