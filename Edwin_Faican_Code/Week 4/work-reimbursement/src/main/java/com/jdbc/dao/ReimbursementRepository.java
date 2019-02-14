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
	
	
	public List<Reimbursement> findAllReimbs() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Reimbursement WHERE reimb_resolved IS NULL ORDER BY reimb_submitted ASC";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(pk.getInt("reimb_id"), pk.getBigDecimal("reimb_amount"), pk.getDate("reimb_submitted"), pk.getDate("reimb_resolved"), pk.getString("reimb_description"), pk.getBlob("reimb_reciept"), pk.getInt("reimb_author"), pk.getInt("reimb_resolver"), pk.getInt("reimb_status_id"), pk.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	public static List<Reimbursement> findReimbs(int user) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Reimbursement WHERE reimb_author = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, user);
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(pk.getInt("reimb_id"), pk.getBigDecimal("reimb_amount"), pk.getDate("reimb_submitted"), pk.getDate("reimb_resolved"), pk.getString("reimb_description"), pk.getBlob("reimb_reciept"), pk.getInt("reimb_author"), pk.getInt("reimb_resolver"), pk.getInt("reimb_status_id"), pk.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbs;
	}
	
	
	public Reimbursement newReimb(int type, int user, BigDecimal amount, String desc, int status, Date submitted) {
		Reimbursement reimb = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Reimbursement(reimb_type_id, reimb_author, reimb_amount, reimb_reciept, reimb_description, reimb_status_id, reimb_submitted) VALUES(?,?,?,?,?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			Blob reciept = conn.createBlob();
			
			ps.setInt(1, type);
			ps.setInt(2, user);
			ps.setBigDecimal(3, amount);
			ps.setBlob(4, reciept);
			ps.setString(5, desc);
			ps.setInt(6, status);
			ps.setDate(7, submitted);
			
			
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				reimb.setReimbId((pk.getInt(1)));
				reimb.setType(type);
				reimb.setReimbAmount(amount);
				reimb.setAuthor(user);
				reimb.setDesc(desc);
				reimb.setStatusid(status);
				reimb.setSubmitted(submitted);
				reimb.setReciept(reciept);
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimb;
	}
	
	public static Reimbursement resolve(Reimbursement reimb){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call resolve(?,?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, reimb.getReimbId());
			cs.setInt(2, reimb.getResolver());
			cs.setDate(3, reimb.getResolved());
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
//		Reimbursement reimb = newReimb(1,1,new BigDecimal("200"), "This is a descrpition", 1, new Date(2019, 02, 14));
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
