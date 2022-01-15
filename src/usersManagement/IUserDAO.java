package usersManagement;

import java.util.List;

public interface IUserDAO {	
	void addUser(User u);
	void dropUser(int userID);
	boolean isExist(String email , String password);
	boolean emailTaken(String email);
	void changeStatus(int userID,int status);
	void updateLastLogin(int userID);
	User getUser(int userID);
	User getUser(String email);
	List<User> getUsers();
	List<User> getOnlineUsers();
}