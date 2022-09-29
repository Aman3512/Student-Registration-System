package com.masai.bean;

public class Course {

	private int cid;
	private String name;
	private int fee;
	
	public Course() {
		
	}

	public Course(int cid, String name, int fee) {
		super();
		this.cid = cid;
		this.name = name;
		this.fee = fee;
	}

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}


	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", fee=" + fee +"]";
	}
	
	
}
