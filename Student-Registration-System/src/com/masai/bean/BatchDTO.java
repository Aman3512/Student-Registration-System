package com.masai.bean;

public class BatchDTO {

	private int roll;
	private String name;
	private String email;
	private String batchName;
	
	public BatchDTO() {
		
	}

	public BatchDTO(int roll, String name, String email, String batchName) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.batchName = batchName;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
}
