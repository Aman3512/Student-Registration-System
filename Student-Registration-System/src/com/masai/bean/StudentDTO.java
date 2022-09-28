package com.masai.bean;

public class StudentDTO {

	private int roll;
	private String name;
	private String enmail;
	
	private String cname;
	private String fee;
	
	public StudentDTO() {
		
	}

	public StudentDTO(int roll, String name, String enmail, String cname, String fee) {
		super();
		this.roll = roll;
		this.name = name;
		this.enmail = enmail;
		this.cname = cname;
		this.fee = fee;
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

	public String getEnmail() {
		return enmail;
	}

	public void setEnmail(String enmail) {
		this.enmail = enmail;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "StudentDTO [roll=" + roll + ", name=" + name + ", enmail=" + enmail + ", cname=" + cname + ", fee="
				+ fee + "]";
	}
	
	
}
