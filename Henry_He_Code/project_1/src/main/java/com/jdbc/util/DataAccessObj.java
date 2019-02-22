package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

public class DataAccessObj {
	
	final static Logger logger = Logger.getLogger(DataAccessObj.class);
	
	public void new_reimbursement(double amount, String desc, int req_id, int reimb_type) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "INSERT INTO ERS_REIMBURSEMENT "
					+ "(REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESC,REIMB_STATUS,REQUESTER,REIMB_TYPE) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
			ps.setString(3,desc);
			ps.setInt(4,0);
			ps.setInt(5,req_id);
			ps.setInt(6,reimb_type);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update_reimbursement(int gtr_id, int r_id, boolean approved) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "UPDATE ERS_REIMBURSEMENT SET "
					+ "REIMB_RESOLVED = ?,"
					+ "REIMB_STATUS = ?,"
					+ "GRANTER = ?"
					+ "WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
			if(approved) {
				ps.setInt(2,1);
			} else {
				ps.setInt(2,2);
			}
			ps.setInt(3, gtr_id);
			ps.setInt(4, r_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void get_employee_reimbursements(int req_id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_REIMBURSEMENT WHERE REQUESTER = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,req_id);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void get_pending_requests() {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS = 0";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyCredentials(String username, String password) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		DataAccessObj dao = new DataAccessObj();
		System.out.println(dao.verifyCredentials("dilbert@company.com","Everybody-Feather-Speak-Breadth-9"));
	}
	
}
