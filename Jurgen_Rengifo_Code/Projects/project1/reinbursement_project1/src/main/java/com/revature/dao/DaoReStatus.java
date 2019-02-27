package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.pojos.PojoReStatus;
import com.revature.interfaces.DAOInterface;

public class DaoReStatus implements DAOInterface<PojoReStatus> {
	private static final Logger log = Logger.getLogger(DaoReStatus.class);
	static {
		log.trace("ReimbursementStatusRepository Class Initialized.");
	}

	public DaoReStatus() {
		log.trace("ReimbursementStatusRepository Object Instantiated.");
	}

	@Override
	public PojoReStatus create(PojoReStatus ii) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement_status(reimb_status) values(?)";
			String[] keys = { "status_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, ii.getReimb_status());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					ii.setStatus_id(rs.getInt("status_id"));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.create()", e);
		}
		return ii;
	}
	@Override
	public PojoReStatus read(Integer iId) {
		PojoReStatus res = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				res = new PojoReStatus(id, status);
			}
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.read()", e);
		}
		return res;
	}
	@Override
	public List<PojoReStatus> readAll() {
		List<PojoReStatus> pes = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_status";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");
				pes.add(new PojoReStatus(id, status));
			}
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
		}
		return pes;
	}
	@Override
	public PojoReStatus update(Integer iId, PojoReStatus ii) {
		PojoReStatus pes = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PojoReStatus temp = new PojoReStatus(rs.getInt("status_id"),
						rs.getString("reimb_status"));

				sql = "update ers_reimbursement_status set reimb_status = ? where status_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, ii.getReimb_status());
				ps.setInt(2, iId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					pes = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.update()", e);
		}
		return pes;
	}
	@Override
	public PojoReStatus delete(PojoReStatus i) {
		PojoReStatus pes = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");
				PojoReStatus temp = new PojoReStatus(id, status);
				sql = "delete from ers_reimbursement_status where status_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, i.getStatus_id());
				if (ps.executeUpdate() > 0) {
					conn.commit();
					pes = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.delete()", e);
		}
		return pes;
	}
}
