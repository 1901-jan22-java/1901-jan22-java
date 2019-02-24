package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.dao.dto.Reimbursement;
import com.revature.ers.dao.pojos.ReimbursementData;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.interfaces.Repository;
import com.revature.ers.services.blob.Receipt;

public class ReimbursementRepository implements Repository<ReimbursementData> {

	private static final Logger log = Logger.getLogger(ReimbursementRepository.class);

	static {
		log.trace("ReimbursementRepository Class Initialized.");
	}

	public ReimbursementRepository() {
		log.trace("ReimbursementRepository Object Instantiated.");
	}

	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_reimbursement_view";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
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

	public List<Reimbursement> getReimbursements(UserData u) {
		List<Reimbursement> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select r.reimb_id as id, r.amount, r.submitted, r.resolved, r.reimb_description as description, "
					+ "r.receipt, auth.username as author, res.username as resolver, s.reimb_status as status, t.reimb_type as type "
					+ "from ers_reimbursement r "
					+ "join (select * from ers_users where user_id = ?) auth on r.author_id = auth.user_id "
					+ "left join ers_users res on res.user_id = r.resolver_id "
					+ "left join ers_reimbursement_status s on s.status_id = r.reimb_status_id "
					+ "left join ers_reimbursement_type t on t.type_id = r.reimb_type_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());

			ResultSet rs = ps.executeQuery();

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
	public ReimbursementData create(ReimbursementData newItem) {

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
			ps.setInt(7, newItem.getResolver_id());
			ps.setInt(8, newItem.getReimb_status_id());
			ps.setInt(9, newItem.getReimb_type_id());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					newItem.setReimb_id(rs.getInt("reimb_id"));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.create()", e);
		}

		return newItem;

	}

	@Override
	public ReimbursementData read(Integer itemId) {
		ReimbursementData res = null;

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

				res = new ReimbursementData(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id);
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.read()", e);
		}

		return res;
	}

	@Override
	public List<ReimbursementData> readAll() {
		List<ReimbursementData> res = new ArrayList<>();

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

				res.add(new ReimbursementData(id, amount, submitted, resolved, description, receipt, author_id,
						resolver_id, status_id, type_id));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public ReimbursementData update(Integer itemId, ReimbursementData newItem) {
		ReimbursementData res = null;

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

				ReimbursementData temp = new ReimbursementData(id, amount, submitted, resolved, description, receipt,
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
	public ReimbursementData delete(ReimbursementData item) {
		ReimbursementData res = null;

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

				ReimbursementData temp = new ReimbursementData(id, amount, submitted, resolved, description, receipt,
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
