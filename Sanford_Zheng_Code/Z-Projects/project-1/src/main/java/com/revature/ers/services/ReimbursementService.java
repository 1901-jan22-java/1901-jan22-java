package com.revature.ers.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.revature.ers.dao.ReimbursementRepository;
import com.revature.ers.dao.ReimbursementStatusRepository;
import com.revature.ers.dao.ReimbursementTypeRepository;
import com.revature.ers.dao.pojos.ReimbursementData;
import com.revature.ers.dao.pojos.ReimbursementStatusData;
import com.revature.ers.dao.pojos.ReimbursementTypeData;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.services.dto.Reimbursement;
import com.revature.ers.services.dto.User;

public class ReimbursementService {

	private static final Logger log = Logger.getLogger(ReimbursementService.class);

	private static final ReimbursementRepository reimbRepo = new ReimbursementRepository();
	private static final ReimbursementTypeRepository reimbTypeRepo = new ReimbursementTypeRepository();
	private static final ReimbursementStatusRepository reimbStatusRepo = new ReimbursementStatusRepository();

	private static List<Reimbursement> reimbursements = new ArrayList<>();

//	private static final HashMap<Integer, ReimbursementData> rawData = new HashMap<>();

	private static final BiMap<Integer, String> statusMap = HashBiMap.create();
	private static final BiMap<Integer, String> typesMap = HashBiMap.create();

	static {
		loadDataImage();
		log.trace("ReimbursementService Class Initialized.");
	}

	public ReimbursementService() {
		loadDataImage();
		log.trace("ReimbursementService Object Instantiated. This should not be happening...");
	}

	public static void addReimbursement(Reimbursement r, UserData ud) {
		r.setStatus("Pending");
		ReimbursementData rd = reimbursementToData(r, ud);
		rd.setSubmitted(new Date(Calendar.getInstance().getTimeInMillis()));
		if (reimbRepo.create(rd) == null) {
			log.error("Unable to create reimbursement: " + rd);
			return;
		}
		reimbursements.add(r);
	}

	public static List<String> getAllTypes() {
		List<String> res = new ArrayList<>();

		for (String s : typesMap.values()) {
			res.add(s);
		}

		return res;
	}

	public static void deny(Integer[] reimbIDs, UserData ud) {
		updateStatus(statusMap.inverse().get("Denied"), reimbIDs, ud);
	}

	public static void approve(Integer[] reimbIDs, UserData ud) {
		updateStatus(statusMap.inverse().get("Approved"), reimbIDs, ud);
	}

	public static void updateStatus(Integer newStatus, Integer[] reimbIDs, UserData resData) {
		ReimbursementData[] rds = new ReimbursementData[reimbIDs.length];
		for (int i = 0; i < reimbIDs.length; i++) {
			ReimbursementData rd = reimbRepo.read(reimbIDs[i]);
			rd.setResolved(new Date(Calendar.getInstance().getTimeInMillis()));
			rd.setResolver_id(resData.getUser_id());
			rd.setReimb_status_id(newStatus);
			
			rds[i] = rd;
		}
		reimbRepo.updateAll(reimbIDs, rds);
	}

	public static List<Reimbursement> getAllReimbursements() {
		return reimbRepo.getAllReimbursements();
	}

	public static List<Reimbursement> getReimbursements(UserData ud) {
		return reimbRepo.getReimbursements(ud.getUser_id());
	}

	public static ReimbursementData reimbursementToData(Reimbursement r, UserData ud) {
		Integer s_id = getStatusID(r.getStatus());
		Integer t_id = getTypeID(r.getType());
		if (s_id == null || t_id == null) {
			return null;
		}
		return new ReimbursementData(r.getAmount(), new Date(Calendar.getInstance().getTimeInMillis()), null,
				r.getDescription(), r.getReceipt(), ud.getUser_id(), null, s_id, t_id);
	}

	public static Reimbursement dataToReimbursement(ReimbursementData rd, User u) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MMMMM-dd hh:mm aaa");
		String s = getStatus(rd.getReimb_status_id());
		String t = getType(rd.getReimb_type_id());
		if (s == null || t == null) {
			return null;
		}
		return new Reimbursement(rd.getReimb_id(), rd.getAmount(), sdf.format(rd.getSubmitted()),
				sdf.format(rd.getResolved()), rd.getReimb_description(), rd.getReceipt(), u.getUsername(), null, s, t);
	}

	public static void loadDataImage() {
		loadStatus();
		loadTypes();
		reimbursements = reimbRepo.getAllReimbursements();
	}

	public static void loadStatus() {
		for (ReimbursementStatusData rsd : reimbStatusRepo.readAll()) {
			statusMap.put(rsd.getStatus_id(), rsd.getReimb_status());
		}
	}

	public static void loadTypes() {
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
//	public static BiMap<Integer, String> getStatusMap(Integer id) {
//		return status;
//	}
//
//	public static BiMap<Integer, String> getTypesMap() {
//		return types;
//	}

}
