package com.revature.ers.dao;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.dao.pojos.ReimbursementData;

public class ReimbursementRepositoryTest {

	private static final Logger log = Logger.getLogger(ReimbursementRepositoryTest.class);
	private static ReimbursementRepository rr;
	private static List<ReimbursementData> list = new ArrayList<>();

	@BeforeClass
	public static void setUpBeforeClass() {
		rr = new ReimbursementRepository();
		list.add(new ReimbursementData(Math.random() * 1000, new Date(Calendar.getInstance().getTime().getTime()), null,
				"description", null, 2, null, 1, 2));
		list.add(new ReimbursementData(Math.random() * 1000, new Date(Calendar.getInstance().getTime().getTime()), null,
				"description", null, 2, null, 1, 2));
	}

	@AfterClass
	public static void tearDownAfterClass() {
		rr = null;
		list = null;
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

	@Test
	public void testGetReimbursements() {
		log.info("CallableStatment returned: " + rr.getReimbursements(7));
		log.assertLog(rr.getReimbursements(7) != null, "get reimbursement test with call");;
	}
	
}
