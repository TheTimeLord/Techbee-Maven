package techbee.projects.maven;

import java.util.Scanner;

public class FrontEnd {
	public static void main(String[] args) {
		
		boolean keepGoing;
		Scanner scan = new Scanner(System.in);
		UserProfileDAO database = new UserProfileDAO();
		
		do {
			keepGoing = false;
	
			// Add user
			System.out.print("Add new user? (y/n): ");
			if(scan.nextLine().charAt(0) == 'y') {
				UserProfile user = new UserProfile();
				
				do {
					//TODO: handle input mismatch exceptions one at a time
					System.out.print("Enter first name: ");
					user.setFirstName(scan.nextLine());
					System.out.print("Enter last name: ");
					user.setLastName(scan.nextLine());
					System.out.print("Enter email: ");
					user.setEmailAddress(scan.nextLine());
					System.out.print("Enter password: ");
					user.setPassword(scan.nextLine());
					System.out.print("Confirm password: ");
					user.setPassword_c(scan.nextLine());
					
					if(user.getPassword().compareTo(user.getPassword_c()) != 0) {
						System.out.println("Error: Passwords do not match");
						keepGoing = true;
					}
					else {
						keepGoing = false;
					}
					
				} while(keepGoing);
				
				database.addUser(user);
				
			}
			
			// Print all users
			System.out.print("Would you like to print all users? (y/n): ");
			if(scan.nextLine().charAt(0) == 'y')
				database.displayUsers();
			
			
			// Update a user
			System.out.print("Would you like to update a user? (y/n): ");
			if(scan.nextLine().charAt(0) == 'y') {
				//TODO: handle input mismatch and OOB exceptions
				System.out.print("Which user would you like to update? (0-" + (database.numUsers()-1) + "): ");
				int uid = scan.nextInt();
				scan.nextLine();
				
				System.out.println("User to update:");
				database.displayUser(uid);
				
				//TODO: handle input mismatch exceptions one at a time
				System.out.print("Enter first name: ");
				String firstName = scan.nextLine();
				System.out.print("Enter last name: ");
				String lastName = scan.nextLine();
				System.out.print("Enter email: ");
				String email = scan.nextLine();

				// No password changes allowed right now
				
				database.updateUser(uid, firstName, lastName, email);
				System.out.println("Updated user information:");
				database.displayUser(uid);
				
			}
			
			// Delete a user
			System.out.print("Would you like to delete a user? (y/n): ");
			if(scan.nextLine().charAt(0) == 'y') {
				//TODO: handle input mismatch and OOB exceptions
				System.out.print("Which user would you like to delete? (0-" + (database.numUsers()-1) + "): ");
				int uid = scan.nextInt();
				scan.nextLine();
				
				database.deleteUser(uid);
			}
			
			
			// Ask to continue
			System.out.print("Would you like to continue? (y/n): ");
			if(scan.nextLine().charAt(0) == 'y')
				keepGoing = true;
		} while(keepGoing);
		
	}
}
