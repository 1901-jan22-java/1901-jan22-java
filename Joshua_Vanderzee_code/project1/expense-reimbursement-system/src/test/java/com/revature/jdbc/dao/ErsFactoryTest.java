package com.revature.jdbc.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
//import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.revature.jdbc.pojos.Ers;
import com.revature.jdbc.pojos.ErsReimbursement;
import com.revature.jdbc.pojos.ErsUser;

class ErsFactoryTest {

	ErsUser user = new ErsUser("mthompson", "Manuel", "Thompson", "manuel.thompson@gmail.com");
	
//	@Test
//	void testHash() {
//		Scanner c = new Scanner(System.in);
//		System.out.println(ErsFactory.hashString(c.nextLine()));
//	}
	
//	@Test
//	void testFindAllReimbursements() {
//		Ers ers = new Ers(user);
//		ErsFactory.findAllReimbursements(ers);
//		for (int i = 0; i <= ers.lastReimbursement(); i++) {
//			ErsReimbursement er = ers.getReimbursementByID(i);
//			DateFormat df = DateFormat.getInstance();
//			String date = df.format(er.getReimb_submitted());
//			String dater = "Not yet Resolved";
//			if (er.getReimbResolved() != null)
//				dater = df.format(er.getReimbResolved());
//			System.out.println("Amount: " + er.getReimb_amount() + " Submitted: " + date + 
//					" Resolved: " + dater + " Desc " + er.getReimbDescription() + 
//					" Author: " + er.getReimbAuthor().toString() + 
//					" Resolver: " + er.getReimbResolver().toString() + 
//					" Type: " + er.getReimb_Type() + " Status: " + er.getReimb_Status());
//		}
//	}
	
	@Test
	void testGetAllReimbursements() {
		Ers ers = new Ers(ErsFactory.Login("kswan", "asdf"));
		ErsFactory.getAllReimbursements(ers);
		for (int i = 0; i <= ers.lastReimbursement(); i++) {
			ErsReimbursement er = ers.getReimbursementByID(i);
			DateFormat df = DateFormat.getInstance();
			String date = df.format(er.getReimb_submitted());
			String dater = "Not yet Resolved";
			if (er.getReimbResolved() != null)
				dater = df.format(er.getReimbResolved());
			System.out.println("Amount: " + er.getReimb_amount() + " Submitted: " + date + 
					" Resolved: " + dater + " Desc " + er.getReimbDescription() + 
					" Author: " + er.getReimbAuthor().toString() + 
					" Resolver: " + er.getReimbResolver().toString() + 
					" Type: " + er.getReimb_Type() + " Status: " + er.getReimb_Status());
		}
		
		System.out.println("pending");
		ers = new Ers(ErsFactory.Login("kswan", "asdf"));
		ErsFactory.getAllPendingReimbursements(ers);
		for (int i = 0; i <= ers.lastReimbursement(); i++) {
			ErsReimbursement er = ers.getReimbursementByID(i);
			DateFormat df = DateFormat.getInstance();
			String date = df.format(er.getReimb_submitted());
			String dater = "Not yet Resolved";
			if (er.getReimbResolved() != null)
				dater = df.format(er.getReimbResolved());
			System.out.println("Amount: " + er.getReimb_amount() + " Submitted: " + date + 
					" Resolved: " + dater + " Desc " + er.getReimbDescription() + 
					" Author: " + er.getReimbAuthor().toString() + 
					" Resolver: " + er.getReimbResolver().toString() + 
					" Type: " + er.getReimb_Type() + " Status: " + er.getReimb_Status());
		}
		
		System.out.println("resolved");
		ers = new Ers(ErsFactory.Login("kswan", "asdf"));
		ErsFactory.getAllResolvedReimbursements(ers);
		for (int i = 0; i <= ers.lastReimbursement(); i++) {
			ErsReimbursement er = ers.getReimbursementByID(i);
			DateFormat df = DateFormat.getInstance();
			String date = df.format(er.getReimb_submitted());
			String dater = "Not yet Resolved";
			if (er.getReimbResolved() != null)
				dater = df.format(er.getReimbResolved());
			System.out.println("Amount: " + er.getReimb_amount() + " Submitted: " + date + 
					" Resolved: " + dater + " Desc " + er.getReimbDescription() + 
					" Author: " + er.getReimbAuthor().toString() + 
					" Resolver: " + er.getReimbResolver().toString() + 
					" Type: " + er.getReimb_Type() + " Status: " + er.getReimb_Status());
		}
	}

//	@Test
//	void testCreateReimbursement() {
//		Ers ers = new Ers(user);
//		ers.AddReimbursement(100, ers.getUser(), "OTHER");
//		ErsFactory.CreateReimbursement(ers);
//	}
	
//	@Test
//	void testLogin() {
//		assertTrue(ErsFactory.Login("mthompson", "password"));
//		assertFalse(ErsFactory.Login("mthompson", "passwor"));
//		assertFalse(ErsFactory.Login("mthompso", "password"));
//		assertFalse(ErsFactory.Login("mthompso", "passwor"));
//	}

//	@Test
//	void testCreateUser() {
//		Ers ers = new Ers(user);
//		ErsFactory.CreateUser(ers);
//	}

}
