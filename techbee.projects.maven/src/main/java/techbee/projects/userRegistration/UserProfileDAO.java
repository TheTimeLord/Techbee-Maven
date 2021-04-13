package techbee.projects.userRegistration;

import java.util.ArrayList;

public class UserProfileDAO {
ArrayList<UserProfile> data = new ArrayList();
	
	// Create User
	public void addUser(UserProfile user) {
		data.add(user);
	}
	
	// Read Users
	public void displayUsers() {
		System.out.println("----------------------------");
		for(int i=0; i<data.size(); i++) {
			System.out.println("First Name: " + data.get(i).getFirstName());
			System.out.println("Last Name: " + data.get(i).getLastName());
			System.out.println("Email: "  + data.get(i).getEmailAddress());
			System.out.println("----------------------------");
		}
	}
	public void displayUser(int userIndex) {
		if(userIndex >= data.size() || userIndex < 0)
			System.out.println("Error: User index out of bounds");
		else {
			System.out.println("First Name: " + data.get(userIndex).getFirstName());
			System.out.println("Last Name: " + data.get(userIndex).getLastName());
			System.out.println("Email: "  + data.get(userIndex).getEmailAddress());
		}
	}
	
	// Update User
	public void updateUser(int userIndex, String firstName, String lastName, String email) {
		if(userIndex >= data.size() || userIndex < 0)
			System.out.println("Error: User index out of bounds");
		else {
			data.get(userIndex).setFirstName(firstName);
			data.get(userIndex).setLastName(lastName);
			data.get(userIndex).setEmailAddress(email);
		}
	}
	
	// Delete User
	public void deleteUser(int userIndex) {
		if(userIndex >= data.size() || userIndex < 0)
			System.out.println("Error: User index out of bounds");
		else {
			data.remove(userIndex);
		}
	}
	
	// Number of users
	public int numUsers() {
		return data.size();
	}
}
