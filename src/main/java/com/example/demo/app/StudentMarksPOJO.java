package com.example.demo.app;

public class StudentMarksPOJO {

	private int rollno;
	private int maths;
	private int english;
	private int hindi;
	private int science;
	private int physics;
	private int chemistry;
	private int biology;
	private int maxmarks;
	private float obtainedmarks;
	private float percentage;

	public float getPercentage() {
		return percentage;
	}

	public float getObtainedmarks() {
		return obtainedmarks;
	}

	public void setObtainedmarks(float obtainMarks) {
		this.obtainedmarks = obtainMarks;
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
	
	public int getMaths() {
		return maths;
	}
	
	public void setMaths(int maths) {
		this.maths = maths;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getHindi() {
		return hindi;
	}
	
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	
	public int getScience() {
		return science;
	}
	
	public void setScience(int science) {
		this.science = science;
	}
	
	public int getPhysics() {
		return physics;
	}
	
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	
	public int getChemistry() {
		return chemistry;
	}
	
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	
	public int getBiology() {
		return biology;
	}
	
	public void setBiology(int biology) {
		this.biology = biology;
	}
	
	public float getMaxmarks() {
		return maxmarks;
	}
	
	public void setMaxmarks(int maxmarks) {
		this.maxmarks = maxmarks;
	}
	
	@Override
	public String toString() {
		return "StudentMarksPOJO [rollno=" + rollno + ", maths=" + maths + ", english=" + english + ", hindi=" + hindi
				+ ", science=" + science + ", physics=" + physics + ", chemistry=" + chemistry + ", biology=" + biology
				+ ", maxmarks=" + maxmarks + "]";
	}


}
