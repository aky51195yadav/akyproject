package com.example.demo.app;

public class StudentsPOJO {

	private int rollNum;
	private String stuName;
	private String subject;
	private float obtainedMarks;
	private float maxMarks;
	private float totalMaxMarks;
	private float totalObtMarks;
	private float percentage;

	public float getTotalMaxMarks() {
		return totalMaxMarks;
	}

	public void setTotalMaxMarks(float totalMaxMarks) {
		this.totalMaxMarks = totalMaxMarks;
	}

	public float getTotalObtMarks() {
		return totalObtMarks;
	}

	public void setTotalObtMarks(float totalObtMarks) {
		this.totalObtMarks = totalObtMarks;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public StudentsPOJO() {

	}

	public StudentsPOJO(int rollNum, String stuName, String subject, float obtMarks, float maxMarks) {
        this.rollNum = rollNum;
        this.stuName = stuName;
		this.subject = subject;
		this.obtainedMarks = obtMarks;
		this.maxMarks = maxMarks;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public float getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(float obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public float getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(float maxMarks) {
		this.maxMarks = maxMarks;
	}

	@Override
	public String toString() {
		return "StudentsPOJO [rollNum=" + rollNum + ", StuName=" + stuName + ", subject=" + subject + ", obtainedMarks="
				+ obtainedMarks + ", maxMarks=" + maxMarks + "]";
	}
}
