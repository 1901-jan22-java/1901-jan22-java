package com.revature.ers.dao.dto;

import java.util.Arrays;

public class ResolveReimbursementParameters {
	private User resolver;
	private Integer[] reimbs;

	public ResolveReimbursementParameters() {
		super();
	}

	public ResolveReimbursementParameters(User resolver, Integer[] reimbs) {
		super();
		this.resolver = resolver;
		this.reimbs = reimbs;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public Integer[] getReimbs() {
		return reimbs;
	}

	public void setReimbs(Integer[] reimbs) {
		this.reimbs = reimbs;
	}

	@Override
	public String toString() {
		return "Parameters [resolver=" + resolver + ", reimbs=" + Arrays.toString(reimbs) + "]";
	}

}
