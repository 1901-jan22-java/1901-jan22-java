package com.revature.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.revature.dao.DaoReimbursement;
import com.revature.dao.DaoReStatus;
import com.revature.dao.DaoReType;
import com.revature.dto.Reimbursement;
import com.revature.pojos.PojoReimbursement;
import com.revature.pojos.ReimbursementStatusData;
import com.revature.pojos.ReimbursementTypeData;
import com.revature.pojos.UserData;

public class ReimbursementService {

	private static final Logger log = Logger.getLogger(ReimbursementService.class);

	private static final DaoReimbursement reimbRepo = new DaoReimbursement();
	private static final DaoReType reimbTypeRepo = new DaoReType();
	private static final DaoReStatus reimbStatusRepo = new DaoReStatus();
	private static List<Reimbursement> reimbursements = new ArrayList<>();
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
		PojoReimbursement rd = reimbursementToData(r, ud);
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

	public static void updateStatus(Integer newStatus, Integer[] reimbIDs, UserData ud) {
		for (Integer id : reimbIDs) {
			PojoReimbursement rd = reimbRepo.read(id);
			rd.setResolved(new Date(Calendar.getInstance().getTimeInMillis()));
			rd.setResolver_id(ud.getUser_id());
			rd.setReimb_status_id(newStatus);
			reimbRepo.update(id, rd);
		}
	}

	public static List<Reimbursement> getAllReimbursements() {
		return reimbRepo.getAllReimbursements();
	}

	public static List<Reimbursement> getReimbursements(UserData ud) {
		return reimbRepo.getReimbursements(ud.getUser_id());
	}

	public static PojoReimbursement reimbursementToData(Reimbursement r, UserData ud) {
		Integer s_id = getStatusID(r.getStatus());
		Integer t_id = getTypeID(r.getType());
		if (s_id == null || t_id == null) {
			return null;
		}
		return new PojoReimbursement(r.getAmount(), new Date(Calendar.getInstance().getTimeInMillis()), null,
				r.getDescription(), r.getReceipt(), ud.getUser_id(), null, s_id, t_id);
	}

	public static Reimbursement dataToReimbursement(PojoReimbursement rd) {
		return null;
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
}
