package usersManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;
import javax.swing.JOptionPane;

import dbConnection.DBConn;

public class IUserImpDAO implements IUserDAO{

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		try {
			String SQL = "insert into users(username,email,password,gender,lastLogin,isOnline) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getLastLogin());
			ps.setInt(6, 0);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void dropUser(int userID) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		try {
			String SQL = "DELETE FROM users WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, userID);
			ps.executeUpdate();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		User u = new User() ;
		try {
			String SQL = "SELECT * FROM users WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			u.setUserId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			u.setGender(rs.getString(5));
			u.setDateRegistration(rs.getString(6));
			u.setLastLogin(rs.getString(7));
			u.setOnline(rs.getInt(8));
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return u;
	}
	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		User u = new User() ;
		try {
			String SQL = "SELECT * FROM users WHERE email=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			u.setUserId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			u.setGender(rs.getString(5));
			u.setDateRegistration(rs.getString(6));
			u.setLastLogin(rs.getString(7));
			u.setOnline(rs.getInt(8));
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return u;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> UL= new ArrayList<>();
		Connection con = DBConn.getConnection();
		User u = new User() ;
		try {
			String SQL = "SELECT * FROM users";
			PreparedStatement ps = con.prepareStatement(SQL);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UL.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7),rs.getInt(8)));
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return UL;
	}
	public List<User> getOnlineUsers() {
		// TODO Auto-generated method stub
		List<User> UL= new ArrayList<>();
		Connection con = DBConn.getConnection();
		User u = new User() ;
		try {
			String SQL = "SELECT * FROM users WHERE ISONLINE=1";
			PreparedStatement ps = con.prepareStatement(SQL);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UL.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7),rs.getInt(8)));
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return UL;
	}
	@Override
	public boolean isExist(String email, String password) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		boolean exist = false;
		try {
			String SQL = "SELECT email , password FROM users WHERE email=? and password=? ";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1,email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(email) && rs.getString(2).equals(password)) {
					exist = true;
				}
			}
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
		return exist;
	}

	public void changeStatus(int userID,int status) {
		Connection con = DBConn.getConnection();
		try {
			String SQL = "UPDATE users SET isOnline=? WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, status);
			ps.setInt(2, userID);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void updateLastLogin(int userID) {
		Connection con = DBConn.getConnection();
		try {
			String SQL = "UPDATE users SET LASTLOGIN=SYSDATE WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, userID);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean emailTaken(String email) {
		Connection con = DBConn.getConnection();
		boolean exist = false;
		try {
			String SQL = "SELECT email , password FROM users WHERE email=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(email)) {
					exist = true;
				}
			}
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
		return exist;
	}
}
