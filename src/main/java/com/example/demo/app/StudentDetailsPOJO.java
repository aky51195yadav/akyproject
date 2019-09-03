package com.example.demo.app;


public class StudentDetailsPOJO {
   
	  private int rollNo;
      private String fatherName;
      private String address;
      
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentDetailsPOJO [rollNo=" + rollNo + ", fatherName=" + fatherName + ", address=" + address + "]";
	}
      


}
