package ba.bildit.DTO;

public class Users {
	
	private int usersID;
	private String firstName;
	private String lastName;
	private String password;
	
	public Users () { 
		
	}
	
	public Users(int usersID, String firstName, String lastName, String password) {
		this.usersID = usersID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public Users(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getUsersID() {
		return usersID;
	}

	public void setUsersID(int usersID) {
		this.usersID = usersID;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User " + usersID + " \n firstName " + firstName + "\n lastName " + lastName + "\n password "
				+ password + "";
	}
	
	
	

}
