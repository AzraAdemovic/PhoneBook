package ba.bildit.DTO;

import java.util.ArrayList;
import java.util.List;

public class Persons {
	private int personsID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	public static List<Persons> list = new ArrayList<>();

	public Persons() {

	}

	public Persons(int personsID, String firstName, String lastName, String phoneNumber) {
		this.personsID = personsID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Persons(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public int getPersonsID() {
		return personsID;
	}

	public void setPersonsID(int personsID) {
		this.personsID = personsID;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person ID " + personsID + "\n firstName " + firstName + "\n lastName= " + lastName + "\n phoneNumber "
				+ phoneNumber + "";
	}

}
