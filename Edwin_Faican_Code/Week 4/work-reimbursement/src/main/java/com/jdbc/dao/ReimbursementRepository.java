package com.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.jdbc.util.ConnectionFactory;
import com.revature.reimbursment.Reimbursement;

public class ReimbursementRepository {
	final static Logger log = Logger.getLogger(ReimbursementRepository.class);
	
	
	public List<String> reimbTypes() {
		List<String> types = new ArrayList<String>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Type ORDER BY reimb_type_id ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				types.add(rs.getString("reimb_type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
	
	public List<Reimbursement> findAllReimbs() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		List<String> types = reimbTypes();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Reimbursement WHERE reimb_resolver IS NULL ORDER BY reimb_submitted ASC";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(pk.getInt("reimb_id"), pk.getBigDecimal("reimb_amount"), pk.getDate("reimb_submitted"), pk.getDate("reimb_resolved"), pk.getString("reimb_description"),pk.getInt("reimb_status_id"), pk.getInt("reimb_author"), pk.getInt("reimb_resolver"), types.get(pk.getInt("reimb_type_id") - 1));
				reimbs.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	public List<Reimbursement> findReimbs(int user) {
		List<String> types = reimbTypes();
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Reimbursement WHERE reimb_author = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, user);
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(pk.getInt("reimb_id"), pk.getBigDecimal("reimb_amount"), pk.getDate("reimb_submitted"), pk.getDate("reimb_resolved"), pk.getString("reimb_description"), pk.getInt("reimb_author"), pk.getInt("reimb_resolver"), pk.getInt("reimb_status_id"), types.get(pk.getInt("reimb_type_id") - 1));
				reimbs.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	
	public Reimbursement newReimb(Reimbursement reimb) {
		List<String> types = reimbTypes();
		Date date = new Date(System.currentTimeMillis());
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Reimbursement(reimb_type_id, reimb_author, reimb_amount, reimb_description, reimb_status_id, reimb_submitted) VALUES(?,?,?,?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);

			ps.setInt(1, types.indexOf(reimb.getType())+1);
			ps.setInt(2, reimb.getAuthor());
			ps.setBigDecimal(3, reimb.getReimbAmount());
			ps.setString(4, reimb.getDesc());
			ps.setInt(5, 1);
			ps.setDate(6, date);

			int numRows = ps.executeUpdate();

			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				reimb.setReimbId((pk.getInt(1)));
				reimb.setStatusid(1);
				reimb.setSubmitted(date);
				conn.commit();
			}
			
		} catch (SQLException e) {

		}
		return reimb;
	}
	
	public Reimbursement resolve(Reimbursement reimb){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call resolve(?,?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, reimb.getReimbId());
			cs.setInt(2, reimb.getResolver());
			cs.setDate(3, new Date(reimb.getResolved()));
			cs.setInt(4,  reimb.getStatusid());
			
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimb;
	}
	
	
//	public static void main(String[] args) {
//		List<Reimbursement> reimbs = findAllReimbs();
//		for(Reimbursement r : reimbs) {
//			log.info(r.toString());
//		}
//		Reimbursement reimb = new Reimbursement();
//		reimb.setAuthor(2);
//		reimb.setDesc("THIS IS A TEST");
//		reimb.setReimbAmount(new BigDecimal("200"));
//		reimb.setType("LODGING");
//		reimb = newReimb(reimb);
//		log.info(reimb.toString());
//		Reimbursement reimb = new Reimbursement();
//		reimb.setReimbId(26);
//		reimb.setResolver(2);
//		reimb.setResolved(new Date(2019, 01, 07));
//		reimb.setStatusid(3);
//		resolve(reimb);
//		log.info(reimb.toString());
//	}
	
}
