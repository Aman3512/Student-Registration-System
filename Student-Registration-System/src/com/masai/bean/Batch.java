package com.masai.bean;

public class Batch {

	private int studentRoll;
	private String batchName;
	
	public Batch() {
		
	}

	public Batch(int studentRoll, String batchName) {
		super();
		this.studentRoll = studentRoll;
		this.batchName = batchName;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
	
}
