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
import com.revature.ers.dao.pojos.UserRole;
import com.revature.ers.interfaces.Repository;

public class UserRoleRepository implements Repository<UserRole> {

	private static Logger log = Logger.getLogger(UserRoleRepository.class);

	private static final HashMap<Integer, String> image = new HashMap<>();

	static {
		log.info("UserRoleRepository Class Instantiated.");
	}

	public static HashMap<Integer, String> getTable() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : image.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}

	@Override
	public boolean create(UserRole newItem) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public UserRole read(Integer itemId) {
		UserRole res = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_user_role where role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("role_id");
				String role = rs.getString("user_role");

				image.put(id, role);
				res = new UserRole(id, role);
			}
			
		} catch (SQLException e) {
			log.error("SQLException in UserRoleRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public List<UserRole> readAll() {
		List<UserRole> res = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_user_role";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("role_id");
				String role = rs.getString("user_role");

				image.put(id, role);
				res.add(new UserRole(id, role));
			}
			
		} catch (SQLException e) {
			log.error("SQLException in UserRoleRepository.readAll()", e);
		}

		return res;
	}

	@Override
	public UserRole update(Integer itemId, UserRole newItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserRole item) {
		// TODO Auto-generated method stub

		return false;
	}
}
