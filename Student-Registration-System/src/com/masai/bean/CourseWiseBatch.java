package com.masai.bean;

public class CourseWiseBatch {

	private int id; 
	private String cname;
	private int totalSeat;
	
	public CourseWiseBatch() {
		
	}

	public CourseWiseBatch(int id, String cname, int totalSeat) {
		super();
		this.id = id;
		this.cname = cname;
		this.totalSeat = totalSeat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	
	
	
}
