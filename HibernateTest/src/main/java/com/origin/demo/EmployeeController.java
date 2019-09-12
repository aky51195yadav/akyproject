package com.origin.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String fillDetails() {
		return "emp_form";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String empDetails(@RequestParam String name, @RequestParam String profile, @RequestParam int salary,
			@RequestParam String address, @RequestParam MultipartFile image) {

		empService.imageWork(image);

		Employee employee = new Employee();
		employee.setName(name);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		empService.saveEmployee(employee);
		return fillDetails();
	}

	@RequestMapping(value = "showAll", method = RequestMethod.GET)
	public ModelAndView showRecords() {
		List<Employee> list = empService.getAllRecords();
		ModelAndView andView = new ModelAndView();
		andView.setViewName("all_details");
		andView.addObject("list", list);
		return andView;
	}

	@RequestMapping(value = "recordsToUpdate", method = RequestMethod.POST)
	public ModelAndView records(@RequestParam int empId, @RequestParam String empName, @RequestParam String profile,
			@RequestParam int salary, @RequestParam String address) {
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setName(empName);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("details_editor");
		andView.addObject("employee", employee);
		return andView;
	}

	@RequestMapping(value = "fetchUpdatedRecord", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveUpdatedRecords(@RequestParam int id, @RequestParam String name,
			@RequestParam String profile, @RequestParam int salary, @RequestParam String address) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		empService.updateDetails(employee);
		return showRecords();
	}

	@RequestMapping(value = "fetchIdToDelete", method = RequestMethod.POST)
	public ModelAndView deleteRecord(@RequestParam int empId) {
		empService.deleteEmployee(empId);
		return showRecords();
	}

}
