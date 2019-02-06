package com.revature.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Associate;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AssociateRepository {
	
	public List<Associate> getAllAssociates(){
		List<Associate> list = new ArrayList<Associate>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "{ call getAllAssociates(?) }";
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Associate a = new Associate();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setPassword(rs.getString(5));
				a.setGrade(rs.getDouble(6));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	public int getBestAssociate() {
		return 0;
	}
	
	public Associate getById(int id) {
		Associate a = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "{ call getAssociateById(?, ?) }";
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, id);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			if(rs.next()) {
				a = new Associate();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setPassword(rs.getString(5));
				a.setGrade(rs.getDouble(6));
			}
			else {
				return null;
				//no associate with this ID
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return a;
	}
	
	public Associate getByEmail(String email) {
		Associate a = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from associates where lower(email) = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Associate();
				a.setId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setPassword(rs.getString(5));
				a.setGrade(rs.getDouble(6));
			}
			else {
				return null;
				//no associate with this email
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public Associate update(Associate a) {
		return null;
	}
	
	public Associate save(Associate a) {
		return null;
	}

}
