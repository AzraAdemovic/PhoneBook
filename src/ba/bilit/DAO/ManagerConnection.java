package ba.bilit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ManagerConnection {

	private static ManagerConnection instance = null;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "toor";
	private static final String CONN_STRING = "jdbc:mysql//localhost:3306/phonebook?serverTimezone=" + TimeZone.getDefault().getID();

	private Connection connection = null;

	private ManagerConnection() {

	}

	public static ManagerConnection getInstance() {
		if (instance == null) {
			instance = new ManagerConnection();
		}
		return instance;

	}

	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		try {
			System.out.println("Connection closed");
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}

}
