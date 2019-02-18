package com.revature.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Reimbursement;
import com.revature.reimbursement.ReimbursementRepo;
import com.revature.user.User;
import com.revature.user.UserRepo;

public class app {
	public static void main(String[] args) {
		ReimbursementRepo x = new ReimbursementRepo();
		UserRepo u = new UserRepo();
		User user = u.findUserByUsername("kevinuser2");
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		r = x.getAllUnresolvedReimbursements();
		x.resolve(r.get(0), user, new Timestamp(System.currentTimeMillis()), 1);
	}
}
