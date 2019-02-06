package com.jdbc.main;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Role;

public class App {

	public static void main(String[] args) {
		RoleRepository repo = new RoleRepository();
		List<Role> roles = repo.findAll();
		System.out.println(roles);
	}
}