package usersManagement;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private String email;
	private String password;
	private String gender;
	private String dateRegistration;
	private String lastLogin;
	private int isOnline;
	
	public User(int userId, String username, String email, String password, String gender, String dateRegistration,
			String lastLogin, int isOnline) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dateRegistration = dateRegistration;
		this.lastLogin = lastLogin;
		this.isOnline = isOnline;
	}

	public User() {
		// TODO Auto-generated constructor stub
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(String dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int isOnline() {
		return isOnline;
	}

	public void setOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", dateRegistration=" + dateRegistration + ", lastLogin=" + lastLogin
				+ ", isOnline=" + isOnline + "]";
	}
	
	
	
}

