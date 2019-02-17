package com.revature.ers.dto.pojos;

import java.sql.Date;

import com.revature.ers.services.Receipt;

public class Reimbursement {

	private Integer reimb_id;
	private Integer amount;
	private Date submitted;
	private Date resolved;
	private String reimb_description;
	private Receipt receipt;
	private Integer author_id;
	private Integer resovler_id;
	private Integer reimb_status_id;
	private Integer reimb_type_id;
}
