package com.revature.ers.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.interfaces.Repository;
import com.revature.ers.services.dao.pojos.ReimbursementStatusData;

public class ReimbursementStatusRepository implements Repository<ReimbursementStatusData> {

	private static final Logger log = Logger.getLogger(ReimbursementStatusRepository.class);

	static {
		log.trace("ReimbursementStatusRepository Class Initialized.");
	}

	public ReimbursementStatusRepository() {
		log.trace("ReimbursementStatusRepository Object Instantiated.");
	}

	@Override
	public ReimbursementStatusData create(ReimbursementStatusData newItem) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement_status(reimb_status) values(?)";
			String[] keys = { "status_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, newItem.getReimb_status());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					newItem.setStatus_id(rs.getInt("status_id"));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
		}

		return newItem;

	}

	@Override
	public ReimbursementStatusData read(Integer itemId) {
		ReimbursementStatusData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				res = new ReimbursementStatusData(id, status);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.read()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementStatusData> readAll() {
		List<ReimbursementStatusData> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_status";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				log.trace("What is going on?");
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				res.add(new ReimbursementStatusData(id, status));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementStatusData update(Integer itemId, ReimbursementStatusData newItem) {
		ReimbursementStatusData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ReimbursementStatusData temp = new ReimbursementStatusData(rs.getInt("status_id"),
						rs.getString("reimb_status"));

				sql = "update ers_reimbursement_status set reimb_status = ? where status_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, newItem.getReimb_status());
				ps.setInt(2, itemId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.update()", e);
		}

		return res;
	}

	@Override
	public ReimbursementStatusData delete(ReimbursementStatusData item) {
		ReimbursementStatusData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				ReimbursementStatusData temp = new ReimbursementStatusData(id, status);

				sql = "delete from ers_reimbursement_status where status_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item.getStatus_id());

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.delete()", e);
		}

		return res;
	}
}
