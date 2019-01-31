package com.jdbc.main;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Role;

public class App {

	
	public static void main(String[] args) {
		RoleRepository roleRepo = new RoleRepository();
		List<Role> roles= roleRepo.findAll();
		
		System.out.println(roles);
	}
}
