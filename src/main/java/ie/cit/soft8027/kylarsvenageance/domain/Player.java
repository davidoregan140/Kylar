package ie.cit.soft8027.kylarsvenageance.domain;

import java.util.List;

public class Player {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;

	private List<Equipment> equipmentList;
	
	public List<Equipment> getEquipment() {
		return equipmentList;
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



	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ "]";
	}
	
	
	

}
