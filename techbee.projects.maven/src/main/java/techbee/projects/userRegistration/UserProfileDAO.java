package techbee.projects.userRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserProfileDAO {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://briandb.cik4qr3cytqb.us-west-1.rds.amazonaws.com:3306/userdb";
	final String USER = "admin";
	final String PASS = "brianpass";
	
	Connection conn = null;
	
	// Connect to mySQL database
	public void connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected");
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Disconnect from mySQL database
	public void closeDB() {
		try {
			System.out.println("Closing database connection...");
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Create User
	public void addUser(UserProfile user) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(accountID) FROM users");
			rs.next();
			int id = rs.getInt(1) + 1;
			
			String sql = "INSERT INTO users VALUES("+id+",\'" +
					 user.getFirstName()+ "\', \'" +
					 user.getLastName()+ "\', \'" +
					 user.getEmailAddress()+ "\');";
			
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Read Users
	public void displayUsers() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			System.out.println("----------------------------");
			while(rs.next()) {
				System.out.println("Account ID: " + rs.getInt(1));
				System.out.println("First Name: " + rs.getString(2));
				System.out.println("Last Name: " + rs.getString(3));
				System.out.println("Email: " + rs.getString(4));
				System.out.println("----------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void displayUser(int accountID) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE accountID="+accountID+";");
			rs.next();
			System.out.println("----------------------------");
			System.out.println("Account ID: " + rs.getInt(1));
			System.out.println("First Name: " + rs.getString(2));
			System.out.println("Last Name: " + rs.getString(3));
			System.out.println("Email: " + rs.getString(4));
			System.out.println("----------------------------");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Update User
	public void updateUser(int accountID, String firstName, String lastName, String email) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "UPDATE users SET "+
						  "firstName=\'"+firstName+
						  "\', lastName=\'"+lastName+
						  "\', email=\'"+email+
						  "\' WHERE accountID="+accountID+";";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Delete User
	public void deleteUser(int accountID) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM users WHERE accountID="+accountID+";";
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
