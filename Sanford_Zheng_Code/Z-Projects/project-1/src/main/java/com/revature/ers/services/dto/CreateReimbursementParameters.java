package com.revature.ers.services.dto;

public class CreateReimbursementParameters {
	private User author;
	private Reimbursement[] reimbs;

	public CreateReimbursementParameters() {
		super();
	}

	public CreateReimbursementParameters(User author, Reimbursement[] reimbs) {
		super();
		this.author = author;
		this.reimbs = reimbs;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Reimbursement[] getReimbs() {
		return reimbs;
	}

	public void setReimbs(Reimbursement[] reimbs) {
		this.reimbs = reimbs;
	}

	@Override
	public String toString() {
		return "CreateReimbursementParameters [author=" + author + ", reimbs=" + reimbs + "]";
	}

}
