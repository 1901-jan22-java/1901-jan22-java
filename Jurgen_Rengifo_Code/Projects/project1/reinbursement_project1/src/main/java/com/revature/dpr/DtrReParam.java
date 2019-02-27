package com.revature.dpr;

public class DtrReParam {
	private DprUser author;
	private DprReimbursement[] reimbs;

	public DtrReParam() {
		super();
	}

	public DtrReParam(DprUser author, DprReimbursement[] reimbs) {
		super();
		this.author = author;
		this.reimbs = reimbs;
	}

	public DprUser getAuthor() {
		return author;
	}

	public void setAuthor(DprUser author) {
		this.author = author;
	}

	public DprReimbursement[] getReimbs() {
		return reimbs;
	}

	public void setReimbs(DprReimbursement[] reimbs) {
		this.reimbs = reimbs;
	}

	@Override
	public String toString() {
		return "CreateReimbursementParameters [author=" + author + ", reimbs=" + reimbs + "]";
	}

}
