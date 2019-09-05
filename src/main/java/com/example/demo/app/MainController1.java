package com.example.demo.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		details.saveToDatabase(studentsPOJO);
		return "DetailsSavedToDatabase";
	}

	@RequestMapping(value = "editmarks", method = RequestMethod.POST)
	public ModelAndView editMarks(@RequestParam String subject, @RequestParam float obtainedMarks,
			@RequestParam float maxMarks, @RequestParam int rollNum, @RequestParam String stuName) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MarksEditor");
		modelAndView.addObject("rollNum", rollNum);
		modelAndView.addObject("stuName", stuName);
		modelAndView.addObject("subject", subject);
		modelAndView.addObject("obtMarks", obtainedMarks);
		modelAndView.addObject("maxMarks", maxMarks);
		return modelAndView;
	}

	@RequestMapping(value = "editedmarks", method = RequestMethod.POST)
	public String saveEditedMarks(@RequestParam int rollNum, @RequestParam String stuName, @RequestParam String subject,
			@RequestParam float obtainedMarks, @RequestParam float maxMarks) {
		details.marksUpdated(obtainedMarks, subject, rollNum);

		return "MarksEdited";

	}

	@RequestMapping(value = "recordToDelete", method = RequestMethod.POST)
	public ModelAndView deleteRecord(@RequestParam String subject, @RequestParam float obtainedMarks,
			@RequestParam int rollNum, @RequestParam String stuName) {
		details.recordDelete(rollNum, stuName, subject);

		List<StudentsPOJO> list = details.getStudents(rollNum);
		StudentsPOJO pojo = list.get(0);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("AfterDelete");
		andView.addObject("lists", list);
		andView.addObject("sd", pojo);
		return andView;
	}

	@RequestMapping(value = "loadExcel", method = RequestMethod.POST)
	public void uploadExcel(@RequestParam MultipartFile mf) {
		File f = new File("E:/Ankit Yadav/ServerFiles", mf.getOriginalFilename());
		try {
			mf.transferTo(f);
			List<StudentsPOJO> list = details.readFile(f);
		   details.saveExcelToDatabase(list);
		  
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
