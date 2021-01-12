package shopping.Models;

public class User {
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean authenticateUser() {
		if(this.username.equals("admin") && this.password.contentEquals("123456"))
			return true;
		
		return false;
	}
}
