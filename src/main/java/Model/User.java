package Model;

public class User {

	public int userId;
	public String username;
	String email;
	String password;
	public String role;
	String customerId;
	
	public User(int userId, String username, String password, String email, String role, String customerId) {
		
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public User(String username, String password, String email, String role) {

		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(int userId, String username, String password, String email,  String role) {

		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
