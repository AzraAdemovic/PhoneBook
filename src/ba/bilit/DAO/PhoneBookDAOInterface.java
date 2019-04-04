package ba.bilit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ba.bildit.DTO.Persons;
import ba.bildit.DTO.Users;

public interface PhoneBookDAOInterface {
	
	public boolean createUser() throws SQLException;

	public ArrayList<Persons> getPersons() throws SQLException;

	public Users getUser(int userID) throws SQLException;

	public Persons getPerson(String lastName, List<Persons> list) throws SQLException;

	public boolean updatePeson(Persons person) throws SQLException;

	public boolean deletePerson(Persons person) throws SQLException;

	public boolean savePerson(Persons person) throws SQLException;

	public Persons getPerson(int personsID) throws SQLException;

}
