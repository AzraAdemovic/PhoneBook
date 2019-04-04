package ba.bildit.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ba.bild.UI.Menu;
import ba.bild.UI.PhoneBookUI;
import ba.bildit.BO.PhoneBookBO;
import ba.bildit.DTO.Persons;
import ba.bilit.DAO.PhoneBookDAOImplementation;

public class RunApp {

	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		// Business layer
		PhoneBookBO PBBO = new PhoneBookBO();
		// User Interface layer
		PhoneBookUI PBUI = new PhoneBookUI();
		Menu menu = new Menu();
		ArrayList<Persons> list;
		Persons person;
		int personId;
		String password = null;
		// Data Access Layer
		PhoneBookDAOImplementation PBDAO = new PhoneBookDAOImplementation();
		boolean running = true;

		while (running) {

			menu.showOptions();
			int option = input.nextInt();
			switch (option) {

			case 1:
				person = PBUI.createPerson();
				if (PBBO.isPhoneNumberValid(person.getPhoneNumber())) {
					PBDAO.savePerson(person);
				} else {
					System.out.println("Contact can not be saved. Please try again.");
				}

				break;
			case 2:
				System.out.print("Please enter person's id you'd like to update: ");
				personId = input.nextInt();
				try {

					person = PBDAO.getPerson(personId);
					Persons editPerson = PBUI.editPerson();

					if (PBDAO.updatePeson(editPerson)) {
						System.out.println("Updated.");
					} else {
						System.out.println("Failed.");
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Please enter persons id : ");
				int personsID = input.nextInt();
				PBUI.deletePerson(personsID);

				break;
			case 4:
				PBUI.doSearch();
				break;
			case 5:
				try {
					list = PBDAO.getPersons();
					PBUI.printAllContacts(list);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case 6:
				PBUI.createUser();
				if (PBBO.isPasswordValid(password)) {
					PBDAO.createUser();

				}
				break;
			case 7:
				running = false;
				break;
			default:
				System.out.println("Choose one of following options.");
				break;
			}
		}
		input.close();
	}

}
