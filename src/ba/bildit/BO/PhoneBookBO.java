package ba.bildit.BO;

import ba.bildit.DTO.Persons;
import ba.bildit.DTO.Users;

public class PhoneBookBO {

	Persons persons = new Persons();
	Users users = new Users();

	public boolean isUserNull(Users user) {
		if (user == null) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isPasswordValid(String password) {
		if (users.getPassword().length() < 8) {
			System.out.println("Please enter at least eight characters.");

			return false;
		}
		return true;
	}

	public boolean isPasswordCorrect(String pass) {

		if (pass.equals(users.getPassword())) {
			return true;
		} else {
		}
		System.out.println("Password is incorrect,please try again.");
		return false;

	}

	public boolean isPhoneNumberValid(String phoneNmber) {
		for (int i = 0; i < persons.getPhoneNumber().length(); i++) {
			if (!Character.isDigit(persons.getPhoneNumber().charAt(i))) {
				System.out.println("This field can contain only digits.");
				return false;
			}
		}
		return true;
	}

}
