package com.revature.ers.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.revature.ers.dao.ReimbursementStatusRepository;
import com.revature.ers.dao.pojos.ReimbursementStatusData;

/**
 * These names are ginourmous
 * 
 * @author Sanford
 *
 */
public class ReimbursementStatusRepositoryTest {

	public static void main(String[] args) {
		ReimbursementStatusRepository repo = new ReimbursementStatusRepository();
		
		List<ReimbursementStatusData> data = repo.readAll();
		System.out.println(data.size());
		for(ReimbursementStatusData rsd: data)
			System.out.println(rsd);
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
		fail("Not yet implemented"); // TODO
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
