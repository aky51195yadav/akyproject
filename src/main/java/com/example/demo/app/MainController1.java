package com.example.demo.app;

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
	
	@RequestMapping(value = "fetchdata", method = RequestMethod.GET)
	public String rollPage()
	{
		return "RollNoPage1";
	}
	
	
	@RequestMapping(value = "savedata", method = RequestMethod.POST)
	public ModelAndView addDetails(@RequestParam int rollNum)
	{   
		List<StudentDetailsPOJO> list = details.getStudentDetails(rollNum);
		List<StudentsPOJO> list1 = details.getStudents(rollNum);
		StudentsPOJO pojo = list1.get(0);
	    String sname = pojo.getStuName();
		ModelAndView view = new ModelAndView();
		view.setViewName("SendDetailsToDatabase");
		view.addObject("lists", list);
		view.addObject("lists1", list1);
		view.addObject("sname", sname);
		return view;
	}
}
