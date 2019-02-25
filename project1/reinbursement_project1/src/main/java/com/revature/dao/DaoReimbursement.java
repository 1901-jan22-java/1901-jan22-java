package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.dto.Reimbursement;
import com.revature.pojos.PojoReimbursement;
import com.revature.interfaces.Repository;
import com.revature.services.Receipt;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoReimbursement implements Repository<PojoReimbursement> {

	private static final Logger log = Logger.getLogger(DaoReimbursement.class);

	static {
		log.trace("ReimbursementRepository Class Initialized.");
	}

	public DaoReimbursement() {
		log.trace("ReimbursementRepository Object Instantiated.");
	}

	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_view";
			Statement ps = conn.createStatement();

			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				res.add(readReimbursement(rs));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getAllReimbursements()", e);
		}

		return res;
	}

	private static Reimbursement readReimbursement(ResultSet rs) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MMMMM-dd hh:mm aaa");
		Integer id = rs.getInt("id");
		Double amount = rs.getDouble("amount");
		String submitted = sdf.format(rs.getDate("submitted"));
		String resolved = (rs.getDate("resolved") != null) ? sdf.format(rs.getDate("resolved")) : null;
		String description = rs.getString("description");
		Receipt receipt = (Receipt) rs.getBlob("receipt");
		String author = rs.getString("author");
		String resolver = rs.getString("resolver");
		String status = rs.getString("status");
		String type = rs.getString("type");

		return new Reimbursement(id, amount, submitted, resolved, description, receipt, author, resolver, status, type);
	}

	public List<Reimbursement> getReimbursements(Integer user_id) {
		List<Reimbursement> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			CallableStatement cs = conn.prepareCall("BEGIN getReimbView(?, ?); END;");
			cs.setInt(1, user_id);

			cs.registerOutParameter(2, OracleTypes.CURSOR);

			cs.execute();
			ResultSet rs = ((OracleCallableStatement) cs).getCursor(2);

			while (rs.next()) {
				res.add(readReimbursement(rs));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getReimbursements()", e);
		}

		return res;
	}

	public Reimbursement getReimbursement(Integer itemId) {
		Reimbursement res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_view where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = readReimbursement(rs);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getReimbursement()", e);
		}

		return res;
	}

	@Override
	public PojoReimbursement create(PojoReimbursement newItem) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_reimbursement(amount, submitted, resolved, "
					+ "reimb_description, receipt, author_id, resolver_id, reimb_status_id, "
					+ "reimb_type_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String[] keys = { "reimb_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, newItem.getAmount());
			ps.setDate(2, newItem.getSubmitted());
			ps.setDate(3, newItem.getResolved());
			ps.setString(4, newItem.getReimb_description());
			ps.setBlob(5, newItem.getReceipt());
			ps.setInt(6, newItem.getAuthor_id());
			Integer res_id = newItem.getResolver_id();
			if (res_id == null) {
				ps.setNull(7, Types.INTEGER);
			} else {
				ps.setInt(7, res_id);
			}
			ps.setInt(8, newItem.getReimb_status_id());
			ps.setInt(9, newItem.getReimb_type_id());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					newItem.setReimb_id(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.create()", e);
		}

		return newItem;
	}

	@Override
	public PojoReimbursement read(Integer itemId) {
		PojoReimbursement res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				res = new PojoReimbursement(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.read()", e);
		}

		return res;
	}

	@Override
	public List<PojoReimbursement> readAll() {
		List<PojoReimbursement> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				res.add(new PojoReimbursement(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public PojoReimbursement update(Integer itemId, PojoReimbursement newItem) {
		PojoReimbursement res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				PojoReimbursement temp = new PojoReimbursement(id, amount, submitted, resolved, description, receipt,
						author_id, resolver_id, status_id, type_id);

				sql = "update ers_reimbursement set amount = ?, submitted = ?, resolved = ?, "
						+ "reimb_description = ?, receipt = ?, author_id = ?, resolver_id = ?, "
						+ "reimb_status_id = ?, reimb_type_id = ? where reimb_id = ?";
				ps = conn.prepareStatement(sql);

				ps.setDouble(1, newItem.getAmount());
				ps.setDate(2, newItem.getSubmitted());
				ps.setDate(3, newItem.getResolved());
				ps.setString(4, newItem.getReimb_description());
				ps.setBlob(5, newItem.getReceipt());
				ps.setInt(6, newItem.getAuthor_id());
				ps.setInt(7, newItem.getResolver_id());
				ps.setInt(8, newItem.getReimb_status_id());
				ps.setInt(9, newItem.getReimb_type_id());
				ps.setInt(10, itemId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}

			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.update()", e);
		}

		return res;
	}

	@Override
	public PojoReimbursement delete(PojoReimbursement item) {
		PojoReimbursement res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getReimb_id());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("reimb_id");
				Double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("reimb_description");
				Receipt receipt = (Receipt) rs.getBlob("receipt");
				Integer author_id = rs.getInt("author_id");
				Integer resolver_id = rs.getInt("resolver_id");
				Integer status_id = rs.getInt("reimb_status_id");
				Integer type_id = rs.getInt("reimb_type_id");

				PojoReimbursement temp = new PojoReimbursement(id, amount, submitted, resolved, description, receipt,
						author_id, resolver_id, status_id, type_id);

				sql = "delete from ers_reimbursement where reimb_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item.getReimb_id());

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}

			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.delete()", e);
		}

		return res;
	}

}
