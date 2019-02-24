package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.pojos.Users;
import com.jdbc.util.ConnectionFactory;

public class UserRepository {

	
	public Users getByUsername(String username) {
		Users user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "Select * FROM ers_users WHERE lower(ers_username) = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username.toLowerCase());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new Users(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6),
				rs.getInt(7)
		   );
		}
	  } catch (SQLException e) {
		e.printStackTrace();
	}
		return user;
	}
	
	
}
