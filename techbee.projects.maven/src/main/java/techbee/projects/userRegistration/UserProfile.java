package techbee.projects.userRegistration;

public class UserProfile {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String password_c;
	
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword_c() {
		return password_c;
	}
	public void setPassword_c(String password_c) {
		this.password_c = password_c;
	}
}
