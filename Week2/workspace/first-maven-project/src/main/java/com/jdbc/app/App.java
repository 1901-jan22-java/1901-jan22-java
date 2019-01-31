package com.jdbc.app;

import java.util.List;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Role;

public class App {
	
	public static void main(String[] args)
	{
		RoleRepository roleRepo = new RoleRepository();
		List<Role> roles = roleRepo.findAll();
		System.out.println(roles);
		//System.out.println(roleRepo.getById(1).toString());
		Role x = new Role(1, "HR Representative");
		System.out.println(roleRepo.update(x));
	}
}
