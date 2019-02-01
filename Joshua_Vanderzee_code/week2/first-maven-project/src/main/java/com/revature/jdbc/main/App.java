package com.revature.jdbc.main;

import java.util.List;

import com.revature.jdbc.dao.RoleRepository;
import com.revature.jdbc.pojos.Roles;

public class App {

	public static void main(String[] args) {
		RoleRepository rolerepo = new RoleRepository();
		List<Roles> roles = rolerepo.findAll();
		for (Roles role : roles)
			System.out.println(role.getId() + " " + role.getTitle());
		
		System.out.println("Role:  " + rolerepo.getByID(2).getTitle());
		
		//Roles r = rolerepo.save("Sales Force Director");
		//System.out.println(r.getTitle());
		
		Roles updateR = rolerepo.Update(new Roles(6 , "Marketing Manager"));
		System.out.println(updateR.getTitle());
	}
}
