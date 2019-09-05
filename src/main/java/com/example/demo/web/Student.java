package com.example.demo.web;

import java.util.List;

public class Student {
	String name, father, roll;
	List<Marks> result;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public List<Marks> getResult() {
		return result;
	}

	public void setResult(List<Marks> result) {
		this.result = result;
	}
}
