package com.revature.service;

import java.util.List;
import java.util.Map;

import com.revature.dao.ReimbursementRepository;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class UserService {
	
	ReimbursementRepository dao = new ReimbursementRepository();
	
	public User logIn(String username, String password) {
		User u = dao.login(username, password);
		if(u == null) {
			return null;
		} else {
			return u;
		}
	}
	
	public List<Reimbursement> getReimb(int user_id){
		return dao.viewReimbursements(user_id);
	}
	
	
	public Reimbursement addReimb(User u, float amount, String description, int type) {
		return dao.addReimbursement(u, amount, description, type);
	}
	
	public Map<Reimbursement, User> viewAll(){
		return dao.viewAll();
	}
	
	public Map<Reimbursement, User> filterByStatus(String status){
		return dao.filterByStatus(status);
	}
	
	public boolean changeStatus(User u, int r_id, int status_id) {
		return dao.changeStatus(u, r_id, status_id);
	}
	
	
}
