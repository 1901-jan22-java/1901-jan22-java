package com.revature.ers.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.services.dao.ReimbursementRepository;
import com.revature.ers.services.dao.pojos.ReimbursementData;

public class ReimbursementRepositoryTest {

	private static ReimbursementRepository rr;
	private static List<ReimbursementData> list = new ArrayList<>();
	
	public static void main(String[] args) {
		ReimbursementRepository repo = new ReimbursementRepository();
		
		for(ReimbursementData rd: repo.readAll())
			System.out.println(rd);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		rr = new ReimbursementRepository();
	}
	@AfterClass
	public static void tearDownAfterClass() {
		rr = null;
	}
	
	@Test
	public void testCreate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRead() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadAll() {
<<<<<<< HEAD
=======
		fail("Not yet implemented"); // TODO
>>>>>>> 8e8ceaa667113afea422f761643a77febde6be3c
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
