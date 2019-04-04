package ba.bilit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ba.bildit.DTO.Persons;
import ba.bildit.DTO.Users;

public class PhoneBookDAOImplementation implements PhoneBookDAOInterface {
	Connection connection = ManagerConnection.getInstance().getConnection();

	Users users = new Users();

	@Override
	public boolean createUser() throws SQLException {

		String query = "INSERT INTO users (firstName,lastName,password) VALUES (?,?,?)";
		try (Connection connection = ManagerConnection.getInstance().getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, users.getFirstName());
			preparedStatement.setString(2, users.getLastName());
			preparedStatement.setString(3, users.getPassword());

			if (preparedStatement.executeUpdate(query) == 1) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public ArrayList<Persons> getPersons() throws SQLException {

		ArrayList<Persons> listperson = new ArrayList<>();

		String query = "SELECT * FROM persons";
		ResultSet rs = null;
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(query);

			while (rs.next()) {

				Persons persons = new Persons(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("phoneNumber"));

				listperson.add(persons);
			}

		}

		return listperson;
	}

	@Override
	public Persons getPerson(int personsID) throws SQLException {
		Persons person = null;
		String query = "SELECT * FROM persons WHERE id = ?";

		ResultSet rs = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, personsID);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				person = new Persons(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("phoneNumber"));
			}

		}
		rs.close();

		return person;

	}

	@Override
	public Persons getPerson(String lastName, List<Persons> list) throws SQLException {
		Persons person = null;
		for (int i = 0; i < list.size(); i++) {
			if (lastName.equals(list.get(i).getLastName())) {
				person = list.get(i);
			}
		}

		return person;
	}

	@Override
	public boolean updatePeson(Persons person) throws SQLException {
		String query = "UPDATE person SET firstName = ?, lastName= ?, phoneNumber=? WHERE person id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3, person.getPhoneNumber());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}

	}

	@Override
	public boolean deletePerson(Persons person) throws SQLException {
		String query = "DELETE FROM persons WHERE id = ?";
		try (PreparedStatement preparedSatement = connection.prepareStatement(query);) {
			preparedSatement.setInt(1, person.getPersonsID());

			if (preparedSatement.executeUpdate() == 1) {
				return true;
			} else {
				return false;

			}

		}

	}

	@Override
	public boolean savePerson(Persons person) throws SQLException {
		String query = "INSERT INTO persons (firstName,lastName,phoneNumber) VALUES (?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3, person.getPhoneNumber());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		}
		return false;
	}
	public boolean saveUser(Users user) throws SQLException {
		String query = "INSERT INTO users (firstName,lastName,password) VALUES (?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, users.getFirstName());
			preparedStatement.setString(2, users.getLastName());
			preparedStatement.setString(3, users.getPassword());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		}
		return false;
	}

	@Override
	public Users getUser(int userID) throws SQLException {
		Users user = null;
		String query = "SELECT * FROM user WHERE id = ?";

		ResultSet rs = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userID);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user = new Users(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("password"));
			}

		}
		rs.close();

		return user;
	}

}
