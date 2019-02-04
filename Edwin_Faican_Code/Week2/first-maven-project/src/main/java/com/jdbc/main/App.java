package com.jdbc.main;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Roles;

public class App {
	public static void main(String[] args) {
		RoleRepository roleRepo = new RoleRepository();
		Roles role = roleRepo.getById(1);
		Roles r = roleRepo.save("Salesperson");		
		List<Roles> roles = roleRepo.findAll();
		Roles rs = new Roles(5, "Faculty");
		Roles rss = roleRepo.update(rs);
		
		System.out.println(role);
		System.out.println(r);
		System.out.println(roles);
		System.out.println(rss);
		
	}
}
