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
import com.revature.ers.services.dao.pojos.UserRoleData;

public class UserRoleRepository implements Repository<UserRoleData> {

	private static Logger log = Logger.getLogger(UserRoleRepository.class);

	static {
		log.trace("UserRoleRepository Class Initialized.");
	}

	public UserRoleRepository() {
		log.trace("UserRoleRepository Object Instantiated.");
	}
	
	@Override
	public boolean create(UserRoleData newItem) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public UserRoleData read(Integer itemId) {
		UserRoleData res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_user_role where role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("role_id");
				String role = rs.getString("user_role");

				res = new UserRoleData(id, role);
			}
			
		} catch (SQLException e) {
			log.error("SQLException in UserRoleRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<UserRoleData> readAll() {
		List<UserRoleData> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_user_role";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("role_id");
				String role = rs.getString("user_role");

				res.add(new UserRoleData(id, role));
			}
			
		} catch (SQLException e) {
			log.error("SQLException in UserRoleRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public UserRoleData update(Integer itemId, UserRoleData newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserRoleData item) {
		// TODO Auto-generated method stub

		return false;
	}
}
