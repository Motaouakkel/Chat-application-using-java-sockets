package dbConnection;

import java.sql.*;

public class TestConn {

	public static void main(String[] args) {
		try {
			Connection con = DBConn.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM personne");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String str = "id : "+rs.getInt(1)+" Name : "+rs.getString(2);
				System.out.println(str);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
