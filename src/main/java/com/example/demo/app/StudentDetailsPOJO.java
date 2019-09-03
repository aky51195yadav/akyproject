package com.example.demo.app;


public class StudentDetailsPOJO {
   
	  private int rollno;
      private String name;
      private String subject;
      private float maxmarks;
      private float obtmarks;
      private float percentage;
      
	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

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
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public float getMaxmarks() {
		return maxmarks;
	}
	
	public void setMaxmarks(float maxmarks) {
		this.maxmarks = maxmarks;
	}
	
	public float getObtmarks() {
		return obtmarks;
	}
	
	public void setObtmarks(float obtmarks) {
		this.obtmarks = obtmarks;
	} 
	  @Override
	public String toString() {
		return "StudentDetailsPOJO [rollno=" + rollno + ", name=" + name + ", subject=" + subject + ", maxmarks="
				+ maxmarks + ", obtmarks=" + obtmarks + "]";
	}

}
