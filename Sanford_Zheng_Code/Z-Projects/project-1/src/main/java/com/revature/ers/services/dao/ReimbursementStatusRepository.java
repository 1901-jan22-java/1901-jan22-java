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
	public boolean create(ReimbursementStatusData newItem) {
		// TODO Auto-generated method stub
		return false;
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
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ReimbursementStatusData item) {
		// TODO Auto-generated method stub
		return false;
	}
}
