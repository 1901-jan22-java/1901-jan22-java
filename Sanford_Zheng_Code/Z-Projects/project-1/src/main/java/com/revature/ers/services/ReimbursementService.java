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

	private static final BiMap<Integer, String> statusMap = HashBiMap.create();
	private static final BiMap<Integer, String> typesMap = HashBiMap.create();

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
		for (ReimbursementStatusData rsd : reimbStatusRepo.readAll()) {
			statusMap.put(rsd.getStatus_id(), rsd.getReimb_status());
		}
		for (ReimbursementTypeData rtd : reimbTypeRepo.readAll()) {
			typesMap.put(rtd.getType_id(), rtd.getReimb_type());
		}
	}

	public static String getStatus(Integer id) {
		return statusMap.get(id);
	}
	public static Integer getStatusID(String status) {
		return statusMap.inverse().get(status);
	}
	
	public static String getType(Integer id) {
		return typesMap.get(id);
	}
	
	public static Integer getTypeID(String type) {
		return typesMap.inverse().get(type);
	}
	
//	public static HashMap<Integer, ReimbursementData> getRawData() {
//		return rawData;
//	}
//
//	
//	
//	public static BiMap<Integer, String> getStatusMap(Integer id) {
//		return status;
//	}
//
//	public static BiMap<Integer, String> getTypesMap() {
//		return types;
//	}

}
