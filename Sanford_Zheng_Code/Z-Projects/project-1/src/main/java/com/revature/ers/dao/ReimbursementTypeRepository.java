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
import com.revature.ers.dao.pojos.ReimbursementType;
import com.revature.ers.interfaces.Repository;

public class ReimbursementTypeRepository implements Repository<ReimbursementType> {

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
	public boolean create(ReimbursementType newItem) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public ReimbursementType read(Integer itemId) {
		ReimbursementType res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				image.put(id, type);
				res = new ReimbursementType(id, type);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.getAllTypes()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementType> readAll() {
		List<ReimbursementType> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				image.put(id, type);
				res.add(new ReimbursementType(id, type));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.getAllTypes()", e);
		}

		return res;
	}

	@Override
	public ReimbursementType update(Integer itemId, ReimbursementType newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ReimbursementType item) {
		// TODO Auto-generated method stub
		return false;
	}
}
