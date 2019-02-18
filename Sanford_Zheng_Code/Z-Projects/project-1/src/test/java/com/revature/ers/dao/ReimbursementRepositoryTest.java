package com.revature.ers.dao;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.services.dao.ReimbursementRepository;
import com.revature.ers.services.dao.pojos.ReimbursementData;

public class ReimbursementRepositoryTest {

	ReimbursementRepository rr;
	
	public static void main(String[] args) {
		ReimbursementRepository repo = new ReimbursementRepository();
		
		for(ReimbursementData rd: repo.readAll())
			System.out.println(rd);
	}
	
	@BeforeClass
	public void setUpBeforeClass() {
		rr = new ReimbursementRepository();
	}
	@AfterClass
	public void tearDownAfterClass() {
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
