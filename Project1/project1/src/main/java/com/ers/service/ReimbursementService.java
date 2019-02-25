package com.ers.service;

import com.jdbc.dao.ReimbursmentRepository;
import com.jdbc.pojos.Reimbursement;
import com.jdbc.pojos.Users;

public class ReimbursementService {
	
	ReimbursmentRepository reimbDao = new ReimbursmentRepository();

	public Reimbursement addReimbursement(Reimbursement reimb) {
		return reimbDao.addReimbursement(reimb);
	}
}
