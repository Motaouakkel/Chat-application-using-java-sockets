package usersManagement;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import dbConnection.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime; 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserImpDAO ob = new IUserImpDAO();
		User u = ob.getUser(21);
		System.out.println(u);
		
	}

}
