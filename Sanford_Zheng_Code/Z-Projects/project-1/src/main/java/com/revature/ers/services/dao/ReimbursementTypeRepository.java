package com.revature.ers.services.dao;

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
import com.revature.ers.interfaces.Repository;
import com.revature.ers.services.dao.pojos.ReimbursementTypeData;

public class ReimbursementTypeRepository implements Repository<ReimbursementTypeData> {

	private static Logger log = Logger.getLogger(ReimbursementTypeRepository.class);

	private static final HashMap<Integer, String> image = new HashMap<>();

	static {
		log.info("ReimbursementTypeRepository Class Instantiated.");
	}

	public static HashMap<Integer, String> getTable() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : image.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}

	@Override
	public boolean create(ReimbursementTypeData newItem) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public ReimbursementTypeData read(Integer itemId) {
		ReimbursementTypeData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				image.put(id, type);
				res = new ReimbursementTypeData(id, type);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.getAllTypes()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementTypeData> readAll() {
		List<ReimbursementTypeData> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				image.put(id, type);
				res.add(new ReimbursementTypeData(id, type));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.getAllTypes()", e);
		}

		return res;
	}

	@Override
	public ReimbursementTypeData update(Integer itemId, ReimbursementTypeData newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ReimbursementTypeData item) {
		// TODO Auto-generated method stub
		return false;
	}
}
