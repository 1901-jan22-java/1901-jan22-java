package com.jdbc.main;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Role;

public class App {

	
	public static void main(String[] args) {
		RoleRepository roleRepo = new RoleRepository();
		
		
		//System.out.println(roles);
		//System.out.println(roleRepo.getById(1));
		Role r = roleRepo.save("Salesforce Director");
		List<Role> roles= roleRepo.findAll();
	}
}