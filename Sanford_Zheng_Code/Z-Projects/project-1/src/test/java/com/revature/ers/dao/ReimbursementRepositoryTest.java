package com.revature.ers.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.dao.pojos.ReimbursementData;

public class ReimbursementRepositoryTest {

	private static ReimbursementRepository rr;
	private static List<ReimbursementData> list = new ArrayList<>();

	public static void main(String[] args) {

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
		for (ReimbursementData rd : rr.readAll()) {
			Assert.assertEquals(rd.getReimb_id(), "");
			Assert.assertEquals(rd.getAmount(), "");
			Assert.assertEquals(rd.getSubmitted(), "");
			Assert.assertEquals(rd.getResolved(), "");
			Assert.assertEquals(rd.getReceipt(), "");
			Assert.assertEquals(rd.getAuthor_id(), "");
			Assert.assertEquals(rd.getResolver_id(), "");
			Assert.assertEquals(rd.getReimb_status_id(), "");
			Assert.assertEquals(rd.getReimb_type_id(), "");
		}
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
