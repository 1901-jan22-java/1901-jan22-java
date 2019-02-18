package com.revature.ers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.revature.ers.services.dto.pojos.Reimbursement;

public class ReimbursementService {

	private static final Logger log = Logger.getLogger(ReimbursementService.class);
	
	/*
	 * May need to change things here to make these hashmaps thread safe.
	 * ANTI-PATTERNS PREVAILED! D:
	 */
	private static final HashMap<Integer, String> types = new HashMap<>();
	private static final HashMap<Integer, String> status = new HashMap<>();
	
	private static final List<Reimbursement> reimbursements = new ArrayList<>();

	static {
		log.trace("ReimbursementService Class Initialized.");
	}
	
	public ReimbursementService() {
		log.trace("ReimbursementService Object Instantiated.");
	}

	/*
	 * Why am I even bothering... these are the same as shallow copies...
	 */
	public static HashMap<Integer, String> getTypes() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : types.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}

	public static HashMap<Integer, String> getStatus() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : status.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}
	
	public void addReimbursement(Reimbursement r) {
		reimbursements.add(r);
	}
	
	public List<Reimbursement> getAllReimbursements(){
		return reimbursements;
	}
	
	/**
	 * No point in this function
	 * 
	 * @return
	 */
//	public static List<Reimbursement> getReimbursements(){
//		List<Reimbursement> clone = new ArrayList<>();
//		for(Reimbursement r: reimbursements) {
//			clone.add(r.clone());
//		}
//		return clone;
//	}

}
