package com.revature.ers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.ers.services.dao.ReimbursementRepository;
import com.revature.ers.services.dao.ReimbursementStatusRepository;
import com.revature.ers.services.dao.ReimbursementTypeRepository;
import com.revature.ers.services.dao.dto.Reimbursement;
import com.revature.ers.services.dao.pojos.ReimbursementData;
import com.revature.ers.services.dao.pojos.ReimbursementStatusData;
import com.revature.ers.services.dao.pojos.ReimbursementTypeData;

public class ReimbursementService {

	private static final Logger log = Logger.getLogger(ReimbursementService.class);

	private static final ReimbursementRepository reimbRepo = new ReimbursementRepository();
	private static final ReimbursementTypeRepository reimbTypeRepo = new ReimbursementTypeRepository();
	private static final ReimbursementStatusRepository reimbStatusRepo = new ReimbursementStatusRepository();

	private static final List<Reimbursement> reimbursements = new ArrayList<>();

	private static final HashMap<Integer, ReimbursementData> rawData = new HashMap<>();
	private static final HashMap<Integer, ReimbursementTypeData> types = new HashMap<>();
	private static final HashMap<Integer, ReimbursementStatusData> status = new HashMap<>();

	static {
		loadDataImage();
		log.trace("ReimbursementService Class Initialized.");
	}

	public ReimbursementService() {
		loadDataImage();
		log.trace("ReimbursementService Object Instantiated.");
	}

	public void addReimbursement(Reimbursement r) {
		reimbursements.add(r);
	}

	public List<Reimbursement> getAllReimbursements() {
		return reimbursements;
	}

	public static void loadDataImage() {
		for(ReimbursementData rd : reimbRepo.readAll()) {
			rawData.put(rd.getReimb_id(), rd);
		}
		for(ReimbursementTypeData rtd : reimbTypeRepo.readAll()) {
			types.put(rtd.getType_id(), rtd);
		}
		for(ReimbursementStatusData rsd : reimbStatusRepo.readAll()) {
			status.put(rsd.getStatus_id(), rsd);
		}
	}
	
	public static HashMap<Integer, ReimbursementData> getRawData() {
		return rawData;
	}

	public static HashMap<Integer, ReimbursementTypeData> getTypes() {
		return types;
	}

	public static HashMap<Integer, ReimbursementStatusData> getStatus() {
		return status;
	}

}
