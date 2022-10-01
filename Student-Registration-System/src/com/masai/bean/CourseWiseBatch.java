package com.masai.bean;

public class CourseWiseBatch {

	private int batchId;
	private String batchName;
	private String courseName;
	private int totalSeat;
	
	public CourseWiseBatch() {
		
	}

	public CourseWiseBatch(int batchId, String batchName, String courseName, int totalSeat) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.courseName = courseName;
		this.totalSeat = totalSeat;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	
	
	
}
