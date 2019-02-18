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
	public ReimbursementTypeData create(ReimbursementTypeData newItem) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement_type(reimb_type) values(?)";
			String[] keys = { "type_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, newItem.getReimb_type());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					newItem.setType_id(rs.getInt("type_id"));
				}
			}
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.readAll()", e);
		}

		return newItem;

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
		ReimbursementTypeData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ReimbursementTypeData temp = new ReimbursementTypeData(rs.getInt("type_id"),
						rs.getString("reimb_type"));

				sql = "update ers_reimbursement_type set reimb_type = ? where type_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, newItem.getReimb_type());
				ps.setInt(2, itemId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementTypeData delete(ReimbursementTypeData item) {
		ReimbursementTypeData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				ReimbursementTypeData temp = new ReimbursementTypeData(id, type);

				sql = "delete from ers_reimbursement_type where type_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item.getType_id());

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.readAll()", e);
		}

		return res;
	}
}
