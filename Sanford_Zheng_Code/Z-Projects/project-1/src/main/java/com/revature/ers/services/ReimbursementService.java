package com.revature.ers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.revature.ers.dao.ReimbursementRepository;
import com.revature.ers.dao.ReimbursementStatusRepository;
import com.revature.ers.dao.ReimbursementTypeRepository;
import com.revature.ers.dao.dto.Reimbursement;
import com.revature.ers.dao.pojos.ReimbursementData;
import com.revature.ers.dao.pojos.ReimbursementStatusData;
import com.revature.ers.dao.pojos.ReimbursementTypeData;

public class ReimbursementService {

	private static final Logger log = Logger.getLogger(ReimbursementService.class);

	private static final ReimbursementRepository reimbRepo = new ReimbursementRepository();
	private static final ReimbursementTypeRepository reimbTypeRepo = new ReimbursementTypeRepository();
	private static final ReimbursementStatusRepository reimbStatusRepo = new ReimbursementStatusRepository();

	private static List<Reimbursement> reimbursements = new ArrayList<>();

	private static final HashMap<Integer, ReimbursementData> rawData = new HashMap<>();

	private static final BiMap<Integer, String> status = HashBiMap.create();
	private static final BiMap<Integer, String> types = HashBiMap.create();

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
		for (ReimbursementData rd : reimbRepo.readAll()) {
			rawData.put(rd.getReimb_id(), rd);
		}
		for (ReimbursementStatusData rsd : reimbStatusRepo.readAll()) {
			status.put(rsd.getStatus_id(), rsd.getReimb_status());
		}
		for (ReimbursementTypeData rtd : reimbTypeRepo.readAll()) {
			types.put(rtd.getType_id(), rtd.getReimb_type());
		}
	}

	public static HashMap<Integer, ReimbursementData> getRawData() {
		return rawData;
	}

	public static BiMap<Integer, String> getStatus() {
		return status;
	}

	public static BiMap<Integer, String> getTypes() {
		return types;
	}

}
