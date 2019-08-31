package com.example.demo.app;


public class StudentDetailsPOJO {
   

	  private int rollno;
      private String name;
      private String fname;
      private String address;
      
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	   @Override
		public String toString() {
			return "StudentDetailsPOJO [rollno=" + rollno + ", name=" + name + ", fname=" + fname + ", address=" + address
					+ "]";
		}
      
}
