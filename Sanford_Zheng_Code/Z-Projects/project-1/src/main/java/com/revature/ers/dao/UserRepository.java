package com.revature.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.utils.ConnectionFactory;
import com.revature.ers.dao.pojos.UserDAO;
import com.revature.ers.interfaces.Repository;

public class UserRepository implements Repository<UserDAO> {

	private static Logger log = Logger.getLogger(UserRepository.class);

	static {
		log.info("UserRepository Class Instantiated.");
	}

	@Override
	public boolean create(UserDAO newItem) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public UserDAO read(Integer itemId) {
		UserDAO res = null;

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

				res = new UserDAO(id, username, password, first_name, last_name, email, role_id);
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<UserDAO> readAll() {
		List<UserDAO> res = new ArrayList<>();

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

				res.add(new UserDAO(id, username, password, first_name, last_name, email, role_id));
			}

		} catch (SQLException e) {
			log.error("SQLException in UserRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public UserDAO update(Integer itemId, UserDAO newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserDAO item) {
		// TODO Auto-generated method stub

		return false;
	}
}
