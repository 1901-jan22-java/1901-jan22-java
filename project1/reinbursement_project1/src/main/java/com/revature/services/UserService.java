package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.revature.dao.DaoUser;
import com.revature.dao.DaoUserRole;
import com.revature.dto.Reimbursement;
import com.revature.dto.User;
import com.revature.pojos.UserData;
import com.revature.pojos.UserRoleData;

public class UserService {
	private static final Logger log = Logger.getLogger(UserService.class);
	private static final DaoUser usersRepo = new DaoUser();
	private static final DaoUserRole rolesRepo = new DaoUserRole();
	private static List<User> usersDTO = new ArrayList<>();
	private static final BiMap<Integer, String> roles = HashBiMap.create();

	static {
		loadRoles();
		usersDTO = usersRepo.getAllUsers();
		log.trace("UserService Class Initialized.");
	}

	public UserService() {
		loadRoles();
		usersDTO = usersRepo.getAllUsers();
		log.trace("UserService Object Instantiated.");
	}

	public static List<User> getAllUsers() {
		return usersDTO;
	}

	public static List<String> getAllRoles() {
		List<String> res = new ArrayList<>();

		for (String r : roles.values()) {
			res.add(r);
		}

		return res;
	}

	public static User register(User u) {
		if (usersRepo.read(u.getUsername()) != null)
			return null;
		usersDTO.add(u);
		return dataToUser(usersRepo.create(userToData(u)));
	}

	public static User login(User u) {
		UserData repoUser = usersRepo.read(u.getUsername());
		if (!repoUser.getPassword().equalsIgnoreCase(u.getPassword()))
			return null;
		return dataToUser(repoUser);
	}

	public static User getUser(String un) {
		return usersDTO.stream().filter(user -> user.getUsername().equalsIgnoreCase(un)).findAny().orElse(null);
	}

	public static UserData getUserData(String un) {
		return usersRepo.read(un);
	}

	public static List<Reimbursement> getReimbursements(User u) {
		List<Reimbursement> res = null;
		if (u.getRole().equalsIgnoreCase("Admin")) {
			res = ReimbursementService.getAllReimbursements();
		} else if (u.getRole().equalsIgnoreCase("Employee")) {
			UserData ud = usersRepo.read(u.getUsername());
			res = ReimbursementService.getReimbursements(ud);
		}
		return res;
	}

	public static List<Reimbursement> getReimbursements(UserData ud) {
		List<Reimbursement> res = null;
		if (ud.getRole_id().equals(getRoleID("Admin"))) {
			res = ReimbursementService.getAllReimbursements();
		} else if (ud.getRole_id().equals(getRoleID("Employee"))) {
			UserData udi = usersRepo.read(ud.getUsername());
			res = ReimbursementService.getReimbursements(udi);
		}
		return res;
	}

	public static UserData userToData(User u) {
		log.info(u.getRole());
		Integer userRoleID = getRoleID(u.getRole());
		if (userRoleID == null) {
			log.error("Could not find corresponding role id.");
			return null;
		}
		UserData ud = new UserData(null, u.getUsername(), u.getPassword(), u.getFirst_name(), u.getLast_name(),
				u.getEmail(), userRoleID);
		log.info("User: " + u + "\nConverted to: " + ud);
		return ud;
	}

	public static User dataToUser(UserData ud) {
		String userRole = getRole(ud.getRole_id());
		if (userRole == null) {
			log.error("Could not find corresponding role id.");
			return null;
		}
		User u = new User(ud.getUsername(), ud.getPassword(), ud.getFirst_name(), ud.getLast_name(), ud.getEmail(),
				userRole);
		log.info("UserData: " + ud + "\nConverted to: " + u);
		return u;
	}

	public static Integer getRoleID(String role) {
		return roles.inverse().get(role);
	}

	public static String getRole(Integer id) {
		return roles.get(id);
	}

	public static void loadRoles() {
		for (UserRoleData urd : rolesRepo.readAll())
			roles.put(urd.getRole_id(), urd.getUser_role());
	}

	public static BiMap<Integer, String> getRoles() {
		return roles;
	}

}
