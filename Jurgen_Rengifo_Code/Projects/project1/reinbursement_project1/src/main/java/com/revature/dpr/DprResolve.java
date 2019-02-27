package com.revature.dpr;

import java.util.Arrays;

public class DprResolve {
	private DprUser resolver;
	private Integer[] reimbs;

	public DprResolve() {
		super();
	}

	public DprResolve(DprUser resolver, Integer[] reimbs) {
		super();
		this.resolver = resolver;
		this.reimbs = reimbs;
	}

	public DprUser getResolver() {
		return resolver;
	}

	public void setResolver(DprUser resolver) {
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
