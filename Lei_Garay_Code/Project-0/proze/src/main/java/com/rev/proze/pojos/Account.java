package com.rev.proze.pojos;

public class Account 
{
	public Account(){}
	
	private Integer	id;
	private Integer usr_id;
	private	String	tp;
	private Double	bl;
	
	public Account(Integer id, Integer usr_id, String tp, Double bl) {
		super();
		this.id = id;
		this.usr_id = usr_id;
		this.tp = tp;
		this.bl = bl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public Double getBl() {
		return bl;
	}
	public void setBl(Double bl) {
		this.bl = bl;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", usr_id=" + usr_id + ", tp=" + tp + ", bl=" + bl + "]";
	}

}
