package ba.bild.UI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ba.bildit.DTO.Persons;
import ba.bildit.DTO.Users;
import ba.bilit.DAO.PhoneBookDAOImplementation;

public class PhoneBookUI {
	Scanner input = new Scanner(System.in);
	Persons person = new Persons();
	PhoneBookDAOImplementation PBIDAO = new PhoneBookDAOImplementation();
	ArrayList<Persons> list = new ArrayList<>();

	public Persons createPerson() {
		System.out.println("Please enter person's first name:");
		String firstName = input.nextLine();

		System.out.println("Enter persons's last name :");
		String lastName = input.nextLine();

		System.out.println("Enter persons's phone number:");
		String phoneNumber = input.nextLine();

		person = new Persons(firstName, lastName, phoneNumber);
		System.out.println("Person has been saved.");
		return person;
	}

	public Users createUser() {
		System.out.println("Please enter your first name:");
		String firstName = input.nextLine();

		System.out.println("Enter last name:");
		String lastName = input.nextLine();

		System.out.println("Enter password:");
		String password = input.next();

		Users user = new Users(firstName, lastName, password);
		return user;
	}

	public Persons editPerson() {
		System.out.println("If you want edit existing contact please follow the steps:");
		System.out.println();
		System.out.println("Current name of person is " + person.getFirstName() + " set new name :");
		String firstName = input.nextLine();
		person.setFirstName(firstName);

		System.out.println("Current last  name of person is " + person.getLastName() + " set new last name :");
		String lastName = input.nextLine();
		person.setLastName(lastName);

		System.out.println("Current phoneNumber of person is " + person.getPhoneNumber() + " set new phone number :");
		String phoneNumber = input.nextLine();
		person.setPhoneNumber(phoneNumber);

		return person;

	}

	public void deletePerson(int personsID) {
		
		try {
			PBIDAO.getPerson(personsID);
			System.out.println(person);
			System.out.println("Are you sure that you want delete this contact?\n(R-Run/S-Stop");
			char allow = input.next().charAt(0);
			if (allow == 'R' || allow == 'r') {
				PBIDAO.deletePerson(person);
				System.out.println("Contact deleted.");
			} else {
				System.out.println("Your contact is stil in phonebook.");
			}

		} catch (SQLException e) {
			System.out.println("Incorrect data.");
			e.printStackTrace();
		}
	}

	public void doSearch() throws SQLException {
		System.out.println("Please enter last name of person you'r looking for:");
		String lastName = input.nextLine();
		PBIDAO.getPerson(lastName, Persons.list);
		System.out.println(person);
	}

	public void printAllContacts(ArrayList<Persons> list) {
		for (Persons person : list) {
			System.out.println(person);
		}

	}
}
