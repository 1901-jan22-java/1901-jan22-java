package com.jdbc.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.jdbc.util.ConnectionFactory;
import com.revature.app.App;
import com.revature.associate.associate;
public class Associate_repository {
	final static Logger logger = Logger.getLogger(Associate_repository.class);
	public associate getAssociate(String email) {
		associate asc = new associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from associate where email = ?";
			String[] keys = {"associate_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				logger.info("Result set exsits");
				asc.setFirstName(rs.getString("firstname"));
				asc.setLastName(rs.getString("lastname"));
				asc.setEmail(rs.getString("email"));
				asc.setPassword(rs.getString("password"));
				asc.setGrade(rs.getDouble("grade"));
				asc.setId(rs.getInt("associate_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asc;
	}
	public associate updateGrades(associate asc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call updateGrade(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, asc.getId());
			cs.setDouble(2, asc.getGrade());
			cs.execute();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asc;
	}
}
