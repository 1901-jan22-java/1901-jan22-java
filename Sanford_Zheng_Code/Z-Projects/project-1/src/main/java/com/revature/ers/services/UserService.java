package com.revature.ers.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.revature.ers.dao.UserRepository;
import com.revature.ers.dao.UserRoleRepository;
import com.revature.ers.dao.dto.Reimbursement;
import com.revature.ers.dao.dto.User;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.dao.pojos.UserRoleData;

public class UserService {

	private static final Logger log = Logger.getLogger(UserService.class);

//	private static final ReimbursementService reimbServ = new ReimbursementService();

	private static final UserRepository usersRepo = new UserRepository();
	private static final UserRoleRepository rolesRepo = new UserRoleRepository();

	private static List<User> usersDTO = new ArrayList<>();

//	private static final HashMap<Integer, UserData> rawData = new HashMap<>();
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

	public static User register(User u) {
		usersDTO.add(u);
		return dataToUser(usersRepo.create(userToData(u)));
	}
	
	public static User login(User u) {
		UserData repoUser = usersRepo.read(u.getUsername());
		if(!repoUser.getPassword().equalsIgnoreCase(u.getPassword())) return null;
		return dataToUser(repoUser);
	}

	public static User getUser(String un) {
		return usersDTO.stream().filter( user -> user.getUsername().equalsIgnoreCase(un) ).findAny().orElse(null);
	}
	
	public static UserData getUserData(String un) {
		return usersRepo.read(un);
	}

	
	// These are too much... I shouldn't have started at the back-end...
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
		Integer userRoleID = getRoleID(u.getRole());
		if (userRoleID == null)
			return null;
		UserData ud = new UserData(null, u.getUsername(), u.getPassword(), u.getFirst_name(), u.getLast_name(),
				u.getEmail(), userRoleID);
		return ud;
	}

	public static User dataToUser(UserData ud) {
		String userRole = getRole(ud.getRole_id());
		if (userRole == null)
			return null;
		User u = new User(ud.getUsername(), ud.getPassword(), ud.getFirst_name(), ud.getLast_name(), ud.getEmail(),
				userRole);
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
