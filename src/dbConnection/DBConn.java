package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static Connection Con;
	
	private DBConn() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##project_java","tiger"); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection() {
		return Con;
	}
			
}
