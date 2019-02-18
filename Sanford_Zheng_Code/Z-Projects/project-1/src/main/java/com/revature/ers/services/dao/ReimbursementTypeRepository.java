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
import com.revature.ers.services.dao.pojos.ReimbursementTypeData;

public class ReimbursementTypeRepository implements Repository<ReimbursementTypeData> {

	private static final Logger log = Logger.getLogger(ReimbursementTypeRepository.class);

	static {
		log.trace("ReimbursementTypeRepository Class Initialized.");
	}

	public ReimbursementTypeRepository() {
		log.trace("ReimbursementTypeRepository Object Instantiated.");
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
