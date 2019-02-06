package com.revature.app;

import java.util.List;

import com.revature.data.AssociateRepository;
import com.revature.pojos.Associate;

public class App {
	
	public static void main(String[] args) {
		AssociateRepository repo = new AssociateRepository();
	//	List<Associate> list = repo.getAllAssociates();
	//	System.out.println(list);
		
		System.out.println(repo.getById(1));
	}

}
