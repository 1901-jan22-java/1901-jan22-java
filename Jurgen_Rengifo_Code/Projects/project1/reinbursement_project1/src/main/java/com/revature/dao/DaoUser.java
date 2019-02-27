package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.pojos.UserData;
import com.revature.dpr.DprUser;
import com.revature.interfaces.DAOInterface;

public class DaoUser implements DAOInterface<UserData> {

	private static Logger log = Logger.getLogger(DaoUser.class);

	static {
		log.trace("UserRepository Class Initialized.");
	}

	public DaoUser() {
		log.trace("UserRepository Object Instantiated.");
	}

	public List<DprUser> getAllUsers() {
		List<DprUser> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select username, password, first_name, last_name, email, user_role as role from "
					+ "ers_users u join ers_user_roles ur on u.role_id = ur.role_id";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				res.add(new DprUser(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role")));
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.getAllUsers()", e);
		}

		return res;
	}
	
	public DprUser getUser(Integer iId) {
		DprUser res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select u.username, u.password, u.first_name, u.last_name, u.email, ur.user_role as role from "
					+ "(select * from ers_users where user_id = ?) u join ers_user_roles ur on u.role_id = ur.role_id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				res = new DprUser(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role"));
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.getUser(id)", e);
		}

		return res;
	}
	
	public DprUser getUser(String username) {
		DprUser res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select u.username, u.password, u.first_name, u.last_name, u.email, ur.user_role as role from "
					+ "(select * from ers_users where username = ?) u join ers_user_roles ur on u.role_id = ur.role_id;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				res = new DprUser(rs.getString("username"), rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("role"));
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.getUser(username)", e);
		}

		return res;
	}

	@Override
	public UserData create(UserData ni) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into ers_users(username, password, first_name, last_name, email, role_id) "
					+ "values(lower(?), ?, ?, ?, ?, ?)";
			String[] keys = { "user_id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, ni.getUsername());
			ps.setString(2, ni.getPassword());
			ps.setString(3, ni.getFirst_name());
			ps.setString(4, ni.getLast_name());
			ps.setString(5, ni.getEmail());
			ps.setInt(6, ni.getRole_id());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					ni.setUser_id(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.create()", e);
		}

		return ni;

	}

	@Override
	public UserData read(Integer iId) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

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

	public UserData read(String un) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ers_users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);

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
	public UserData update(Integer iId, UserData ni) {
		UserData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iId);

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
				ps.setString(1, ni.getUsername());
				ps.setString(2, ni.getPassword());
				ps.setString(3, ni.getFirst_name());
				ps.setString(4, ni.getLast_name());
				ps.setString(5, ni.getEmail());
				ps.setInt(6, ni.getRole_id());
				ps.setInt(7, iId);

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
	public UserData delete(UserData i) {
		UserData pes = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "select * from ers_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i.getUser_id());
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
				ps.setInt(1, i.getUser_id());
				if (ps.executeUpdate() > 0) {
					conn.commit();
					pes = temp;
				}
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			log.error("SQLException in UserRepository.delete()", e);
			return null;
		}

		return pes;
	}
}
