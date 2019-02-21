package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.dao.dto.User;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.interfaces.Repository;

public class UserRepository implements Repository<UserData> {

	private static Logger log = Logger.getLogger(UserRepository.class);

	static {
		log.trace("UserRepository Class Initialized.");
	}

	public UserRepository() {
		log.trace("UserRepository Object Instantiated.");
	}

	public List<User> getAllUsers() {
		List<User> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select username, password, first_name, last_name, email, user_role as role from "
					+ "ers_users u join ers_user_roles ur on u.role_id = ur.role_id;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				res.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role")));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getAllUsers()", e);
		}

		return res;
	}
	
	public User getUser(Integer itemId) {
		User res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select u.username, u.password, u.first_name, u.last_name, u.email, ur.user_role as role from "
					+ "(select * from ers_users where user_id = ?) u join ers_user_roles ur on u.role_id = ur.role_id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				res = new User(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role"));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getUser(id)", e);
		}

		return res;
	}
	
	public User getUser(String username) {
		User res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select u.username, u.password, u.first_name, u.last_name, u.email, ur.user_role as role from "
					+ "(select * from ers_users where username = ?) u join ers_user_roles ur on u.role_id = ur.role_id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				res = new User(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role"));
			}

		} catch (SQLException e) {
			log.error("SQLException in ReimbursementRepository.getUser(username)", e);
		}

		return res;
	}

	@Override
	public UserData create(UserData newItem) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_users(username, password, first_name, last_name, email, rold_id) "
					+ "values(?, ?, ?, ?, ?, ?)";
			String[] keys = { "user_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, newItem.getUsername());
			ps.setString(2, newItem.getPassword());
			ps.setString(3, newItem.getFirst_name());
			ps.setString(4, newItem.getLast_name());
			ps.setString(5, newItem.getEmail());
			ps.setInt(6, newItem.getRole_id());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					newItem.setUser_id(rs.getInt("user_id"));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.create()", e);
		}

		return newItem;

	}

	@Override
	public UserData read(Integer itemId) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				Integer role_id = rs.getInt("role_id");

				res = new UserData(id, username, password, first_name, last_name, email, role_id);
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.read()", e);
		}

		return res;
	}

	@Override
	public List<UserData> readAll() {
		List<UserData> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				Integer role_id = rs.getInt("role_id");

				res.add(new UserData(id, username, password, first_name, last_name, email, role_id));
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public UserData update(Integer itemId, UserData newItem) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Integer id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				Integer role_id = rs.getInt("role_id");
				UserData temp = new UserData(id, username, password, first_name, last_name, email, role_id);

				sql = "update ers_reimbursement set username = ?, password = ?, first_name = ?, "
						+ "last_name = ?, email = ?, role_id = ? where user_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, newItem.getUsername());
				ps.setString(2, newItem.getPassword());
				ps.setString(3, newItem.getFirst_name());
				ps.setString(4, newItem.getLast_name());
				ps.setString(5, newItem.getEmail());
				ps.setInt(6, newItem.getRole_id());
				ps.setInt(7, itemId);

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}

			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.update()", e);
		}

		return res;
	}

	@Override
	public UserData delete(UserData item) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getUser_id());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				Integer role_id = rs.getInt("role_id");
				UserData temp = new UserData(id, username, password, first_name, last_name, email, role_id);

				sql = "delete from ers_users where user_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item.getUser_id());

				if (ps.executeUpdate() > 0) {
					conn.commit();
					res = temp;
				}
			}
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.delete()", e);
			return null;
		}

		return res;
	}
}
