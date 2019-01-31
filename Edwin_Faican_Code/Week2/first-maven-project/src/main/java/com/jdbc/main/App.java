package com.jdbc.main;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Roles;

public class App {
	public static void main(String[] args) {
		RoleRepository roleRepo = new RoleRepository();
		List<Roles> roles = roleRepo.findAll();
		
		System.out.println(roles);
	}
}
