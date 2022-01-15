package msgManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConnection.DBConn;

public class IMsgImp implements IMsg{

	@Override
	public void addMsg(Msg msg) {
		
		Connection con = DBConn.getConnection();
		String SQL = "insert into message(contentMsg ,sendingDate ,senderId ) values(? , DEFAULT , ?)";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, msg.getContentMsg());
			ps.setInt(2, msg.getUserId());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
