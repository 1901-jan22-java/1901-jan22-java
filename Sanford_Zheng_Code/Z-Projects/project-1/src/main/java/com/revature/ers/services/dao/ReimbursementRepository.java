package com.revature.ers.services.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.interfaces.Repository;
import com.revature.ers.services.Receipt;
import com.revature.ers.services.dao.pojos.ReimbursementData;

public class ReimbursementRepository implements Repository<ReimbursementData> {

	private static final Logger log = Logger.getLogger(ReimbursementRepository.class);

	static {
		log.trace("ReimbursementRepository Class Initialized.");
	}
	
	public ReimbursementRepository() {
		log.trace("ReimbursementRepository Object Instantiated.");
	}

	@Override
	public boolean create(ReimbursementData newItem) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement(amount, submitted, resolved, "
					+ "reimb_description, receipt, author_id, resolver_id, reimb_status_id, "
					+ "reimb_type_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newItem.getAmount());
			ps.setDate(2, newItem.getSubmitted());
			ps.setDate(3, newItem.getResolved());
			ps.setString(4, newItem.getReimb_description());
			ps.setBlob(5, newItem.getReceipt());
			ps.setInt(6, newItem.getAuthor_id());
			ps.setInt(7, newItem.getResolver_id());
			ps.setInt(8, newItem.getReimb_status_id());
			ps.setInt(9, newItem.getReimb_type_id());

			if (ps.executeUpdate() <= 0)
				return false;

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
			return false;
		}

		return true;
	}

	@Override
	public ReimbursementData read(Integer itemId) {
		ReimbursementData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Integer amount = rs.getInt("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				res = new ReimbursementData(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementData> readAll() {
		List<ReimbursementData> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Integer amount = rs.getInt("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				res.add(new ReimbursementData(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementData update(Integer itemId, ReimbursementData newItem) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean delete(ReimbursementData item) {
		// TODO Auto-generated method stub
		return false;
	}

}
