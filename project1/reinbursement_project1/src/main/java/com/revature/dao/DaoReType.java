package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.pojos.PojoReType;
import com.revature.interfaces.DAOInterface;

public class DaoReType implements DAOInterface<PojoReType> {

	private static final Logger log = Logger.getLogger(DaoReType.class);

	static {
		log.trace("ReimbursementTypeRepository Class Initialized.");
	}

	public DaoReType() {
		log.trace("ReimbursementTypeRepository Object Instantiated.");
	}

	@Override
	public PojoReType create(PojoReType ni) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement_type(reimb_type) values(?)";
			String[] keys = { "type_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, ni.getReimb_type());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					ni.setType_id(rs.getInt("type_id"));
				}
			}
		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.create()", e);
		}

		return ni;

	}

	@Override
	public PojoReType read(Integer iId) {
		PojoReType pes = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				pes = new PojoReType(id, type);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.read()", e);
		}

		return pes;
	}

	@Override
	public List<PojoReType> readAll() {
		List<PojoReType> pes = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_type";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				pes.add(new PojoReType(id, type));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.readAll()", e);
		}

		return pes;
	}

	@Override
	public PojoReType update(Integer iId, PojoReType ni) {
		PojoReType pes = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PojoReType temp = new PojoReType(rs.getInt("type_id"),
						rs.getString("reimb_type"));

				sql = "update ers_reimbursement_type set reimb_type = ? where type_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, ni.getReimb_type());
				ps.setInt(2, iId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					pes = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.update()", e);
		}

		return pes;
	}

	@Override
	public PojoReType delete(PojoReType i) {
		PojoReType pes = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("type_id");
				String type = rs.getString("reimb_type");

				PojoReType temp = new PojoReType(id, type);

				sql = "delete from ers_reimbursement_type where type_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, i.getType_id());

				if (ps.executeUpdate() > 0) {
					conn.commit();
					pes = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementTypeRepository.delete()", e);
		}

		return pes;
	}
}
