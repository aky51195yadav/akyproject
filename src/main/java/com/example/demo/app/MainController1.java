package com.example.demo.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController1 {

	@Autowired
	MappingDetails1 details;

	@RequestMapping(value = "fetchRoll", method = RequestMethod.GET)
	public String rollPage() {
		return "RollNoPage1";
	}

	@RequestMapping(value = "savedata", method = RequestMethod.POST)
	public ModelAndView addDetails(@RequestParam int rollNum) {

		List<StudentDetailsPOJO> list = details.getStudentDetails(rollNum);
		List<StudentsPOJO> list1 = details.getStudents(rollNum);
		float percentage = details.percentage(list1);
		float totalMaxMarks = details.totalMaxMarks(list1);
		float totalObtMarks = details.totalObtMarks(list1);
		StudentsPOJO studentsPOJO = new StudentsPOJO();
		studentsPOJO.setPercentage(percentage);
		studentsPOJO.setTotalObtMarks(totalObtMarks);
		studentsPOJO.setTotalMaxMarks(totalMaxMarks);
		StudentsPOJO pojo = list1.get(0);
		// String stuName = pojo.getStuName();
		// int stuRollNo = pojo.getRollNum();
		// pojo.setNameAsUsual(stuName);
		// pojo.setRollAsUsual(stuRollNo);
		ModelAndView view = new ModelAndView();
		view.setViewName("SendDetailsToDatabase");
		view.addObject("lists", list);
		view.addObject("lists1", list1);
		view.addObject("sd", pojo);
		view.addObject("stotal", studentsPOJO);
		// view.addObject("stuName", stuName);
		// view.addObject("stuRollNo", stuRollNo);
		return view;
	}

	@RequestMapping(value = "savefetcheddata", method = RequestMethod.POST)
	public String savedData(@RequestParam int rollNum, @RequestParam String stuName, @RequestParam String subject,
			@RequestParam float obtMarks, @RequestParam float maxMarks) {
		StudentsPOJO studentsPOJO = new StudentsPOJO(rollNum, stuName, subject, obtMarks, maxMarks);
		Boolean boolean1 = details.saveToDatabase(studentsPOJO);
		return "DetailsSavedToDatabase";
	}

	@RequestMapping(value = "editmarks", method = RequestMethod.POST)
	public String editMarks(@RequestParam String subject, @RequestParam float obtainedMarks,
			@RequestParam float maxMarks) {
            List<?> list = new ArrayList();
            
            
		return "MarksEditor";
	}

}
