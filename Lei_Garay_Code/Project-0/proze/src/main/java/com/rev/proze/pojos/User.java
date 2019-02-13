package com.rev.proze.pojos;

public class User 
{
	public User() {}
	

	private Integer id;
	private String  fn;
	private String  ln;
	private String  em;
	private	String	tp;

	public User(Integer id, String fn, String ln, String em, String tp) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.em = em;
		this.tp = tp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", em=" + em + ", tp=" + tp + "]";
	}

}
