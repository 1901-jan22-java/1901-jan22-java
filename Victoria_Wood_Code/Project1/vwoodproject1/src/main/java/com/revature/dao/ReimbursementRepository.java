package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ReimbursementRepository {
	
	private static Logger log = Logger.getLogger(ReimbursementRepository.class);
	
	public User login(String username, String pwd) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select*from ERS_USERS where ERS_USERNAME = ? and ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();
			if(info.next()) {
				u = new User(info.getInt("ers_users_id"), info.getString("user_first_name"), info.getString("user_last_name"));
				log.trace(u);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Reimbursement> viewReimbursements(int user_id){
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllReimbs(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user_id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getFloat("reimb_amount"), 
						rs.getDate("reimb_submitted"), rs.getDate("reimb_resolved"), rs.getString("reimb_resolver"),
						rs.getString("reimb_description"), rs.getString("reimb_type"), rs.getString("reimb_status"));
				reimbursements.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public Map<Reimbursement, User> viewAll() {
		Map<Reimbursement, User> reimbursements = new LinkedHashMap<Reimbursement, User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAll(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getFloat("reimb_amount"), 
						rs.getDate("reimb_submitted"), rs.getDate("reimb_resolved"), rs.getString("reimb_resolver"),
						rs.getString("reimb_description"), rs.getString("reimb_type"), rs.getString("reimb_status"));
				User u = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_role"));
				reimbursements.put(r, u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public Reimbursement addReimbursement(User u, float amount, Date submitted, String description, int type) {
		Reimbursement r = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES (?, ?, ?, ?, 1, ?)";
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, amount); ps.setDate(2, submitted); ps.setString(3, description);
			ps.setInt(4, u.getId()); ps.setInt(5, type);
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				int r_id = pk.getInt(1);
				r = new Reimbursement(r_id, amount, submitted, u.getFn(), "Pending");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Reimbursement changeStatus(User u, Reimbursement r, int status_id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update ERS_REIMBURSEMENT set reimb_status_id = ?, reimb_resolved = ?, reimb_resolver = ? where reimb_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status_id);
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setInt(3,u.getId());
			ps.setInt(4, r.getId());
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				if(status_id == 2) {
					r.setStatus("Denied");
				} else if (status_id == 3) {
					r.setStatus("Approved");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Map<Reimbursement, User> filterByStatus(String status) {
		Map<Reimbursement, User> reimbursements = new LinkedHashMap<Reimbursement, User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getByStatus(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, status);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"), rs.getFloat("reimb_amount"), 
						rs.getDate("reimb_submitted"), rs.getDate("reimb_resolved"), rs.getString("reimb_resolver"),
						rs.getString("reimb_description"), rs.getString("reimb_type"), rs.getString("reimb_status"));
				User u = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_role"));
				reimbursements.put(r, u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

}
