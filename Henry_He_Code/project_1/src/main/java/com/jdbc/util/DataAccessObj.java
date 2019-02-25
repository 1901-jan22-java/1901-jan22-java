package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.reimbursement;

public class DataAccessObj {
	
	final static Logger logger = Logger.getLogger(DataAccessObj.class);
	
	public int new_reimbursement(double amount, String desc, int req_id, int reimb_type) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "INSERT INTO ERS_REIMBURSEMENT "
					+ "(REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESC,REIMB_STATUS,REQUESTER,REIMB_TYPE) "
					+ "VALUES (?,?,?,?,?,?)";
			logger.info(query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
			ps.setString(3,desc);
			ps.setInt(4,0);
			ps.setInt(5,req_id);
			ps.setInt(6,reimb_type);
			ps.executeUpdate();
			ResultSet rs = (conn.createStatement()).executeQuery("SELECT MAX(REIMB_ID) FROM ERS_REIMBURSEMENT");
			if(rs.next()) return rs.getInt(1);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void update_reimbursement(int gtr_id, int r_id, boolean approved) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "UPDATE ERS_REIMBURSEMENT SET "
					+ "REIMB_RESOLVED = ?,"
					+ "REIMB_STATUS = ?,"
					+ "GRANTER = ?"
					+ "WHERE REIMB_ID = ?";
			logger.info(query);
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
	
	public List<reimbursement> get_reimb_for_employee(int uid) {
		List<reimbursement> rList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_REIMBURSEMENT WHERE REQUESTER=? ORDER BY REIMB_ID";
			logger.info(query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rList.add(new reimbursement(
						rs.getInt("REIMB_ID"),
						rs.getInt("REIMB_TYPE"),
						rs.getInt("REIMB_AMOUNT"),
						rs.getString("REIMB_DESC"),
						rs.getInt("REIMB_STATUS"),
						null,
						rs.getString("REIMB_SUBMITTED"),
						null,
						rs.getString("REIMB_RESOLVED")
				));
			}
			return rList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}
	
	public List<reimbursement> get_reimb_for_manager() {
		List<reimbursement> rList = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_REIMBURSEMENT ORDER BY REIMB_ID";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				rList.add(new reimbursement(
						rs.getInt("REIMB_ID"),
						rs.getInt("REIMB_TYPE"),
						rs.getInt("REIMB_AMOUNT"),
						rs.getString("REIMB_DESC"),
						rs.getInt("REIMB_STATUS"),
						null,
						rs.getString("REIMB_SUBMITTED"),
						null,
						rs.getString("REIMB_RESOLVED")
				));
			}
			return rList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
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
	
	public String verifyCredentials(String username, String password) {
		String str = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_PASSWORD=?";
			logger.info(query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				str = rs.getString("USER_ID") + "," + rs.getString("USER_ROLE_ID");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
//		DataAccessObj dao = new DataAccessObj();
//		List<reimbursement> rList = dao.get_reimb_for_employee(5,2);
//		for( reimbursement r : rList) {
//			System.out.println(r);
//		}
	}
	
}
