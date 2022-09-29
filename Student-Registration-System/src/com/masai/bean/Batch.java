package com.masai.bean;

public class Batch {

	private int batchId;
	private String courseName;
	private int stRoll;
	
	public Batch() {
		
	}

	public Batch(int batchId, String courseName, int stRoll) {
		super();
		this.batchId = batchId;
		this.courseName = courseName;
		this.stRoll = stRoll;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getStRoll() {
		return stRoll;
	}

	public void setStRoll(int stRoll) {
		this.stRoll = stRoll;
	}

	
	
}
