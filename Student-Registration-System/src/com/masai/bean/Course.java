package com.masai.bean;

public class Course {

	private int cid;
	private String name;
	private int fee;
	private int seats;
	
	public Course() {
		
	}

	public Course(int cid, String name, int fee, int seats) {
		super();
		this.cid = cid;
		this.name = name;
		this.fee = fee;
		this.seats = seats;
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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", fee=" + fee + ", seats=" + seats
				+ "]";
	}
	
	
}
