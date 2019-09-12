package com.origin.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeNewController {
	@Autowired
	EmployeeNewService service;

	@RequestMapping(value = "click", method = RequestMethod.GET)
	public String getClickPage() {
		return "enter_click";
	}

	@RequestMapping(value = "getPage", method = RequestMethod.GET)
	public ModelAndView getDetails() {
		List<EmployeeNew> list1 = service.getDetails();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("entry_form");
		mav.addObject("list1", list1);
		return mav;
	}

	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public ModelAndView fetchDetails(@RequestParam String name, @RequestParam String profile,
			@RequestParam String address) {
		List<EmployeeNew> list;
		if (address == "" && profile == "") {
			list = service.getStudentDetails3(name);

		} else if (profile == "") {
			list = service.getStudentDetails1(name, address);
		} else if (address == "") {
			list = service.getStudentDetails2(name, profile);
		} else {
			list = service.getStudentDetails(name, profile, address);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee_data");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value = "boxId")
	public void getCheckbox(@RequestParam int empId)
	{
		System.out.println(empId);
	}

}
