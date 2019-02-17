package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.dao.pojos.ReimbursementStatus;
import com.revature.ers.interfaces.Repository;

public class ReimbursementStatusRepository implements Repository<ReimbursementStatus> {

	private static Logger log = Logger.getLogger(ReimbursementStatusRepository.class);

	private static final HashMap<Integer, String> image = new HashMap<>();

	static {
		log.info("ReimbursementStatusRepository Class Instantiated.");
	}

	public static HashMap<Integer, String> getTable() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : image.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}

	@Override
	public boolean create(ReimbursementStatus newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReimbursementStatus read(Integer itemId) {
		ReimbursementStatus res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_status where status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				image.put(id, status);
				res = new ReimbursementStatus(id, status);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementStatus> readAll() {
		List<ReimbursementStatus> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_status";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("status_id");
				String status = rs.getString("reimb_status");

				image.put(id, status);
				res.add(new ReimbursementStatus(id, status));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementStatusRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementStatus update(Integer itemId, ReimbursementStatus newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ReimbursementStatus item) {
		// TODO Auto-generated method stub
		return false;
	}
}
