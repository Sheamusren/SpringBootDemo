package com.example.domain;

public class Module {

	private Integer mid;
	private String mname;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Module(Integer mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
    	
}
