package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.dao.pojos.ReimbursementDAO;
import com.revature.ers.interfaces.Repository;
import com.revature.ers.services.Receipt;

public class ReimbursementRepository implements Repository<ReimbursementDAO> {

	private static Logger log = Logger.getLogger(ReimbursementRepository.class);
	
	static {
		log.info("ReimbursementRepository Class Instantiated.");
	}

	@Override
	public boolean create(ReimbursementDAO newItem) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "insert into ers_reimbursement() values()";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			}
			
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
			return false;
		}
		
		return true;
	}

	@Override
	public ReimbursementDAO read(Integer itemId) {
		ReimbursementDAO res = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Integer amount = rs.getInt("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt)rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");
				
				res = new ReimbursementDAO( id, amount, submitted, resolved, description,
						receipt, author_id, resolver_id, status_id, type_id );
			}
			
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementDAO> readAll() {
		List<ReimbursementDAO> res = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Integer amount = rs.getInt("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt)rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");
				
				res.add(new ReimbursementDAO( id, amount, submitted, resolved, description,
						receipt, author_id, resolver_id, status_id, type_id ));
			}
			
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementDAO update(Integer itemId, ReimbursementDAO newItem) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean delete(ReimbursementDAO item) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
