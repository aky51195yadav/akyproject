package com.origin.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	@Autowired
	private AccountInfoService accService;

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
		try {
			employee.setImage(image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	@RequestMapping(value = "getPage", method = RequestMethod.GET)
	public String getDetails() {

		return "enter_nameaddress";
	}

	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public ModelAndView getNameAddress(@RequestParam String name, @RequestParam String address) {
		Employee emp = empService.fetchRecord(name, address);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("enter_nameaddress");
		mav.addObject("emp", emp);
		return mav;
	}

	@RequestMapping(value = "getEmpId", method = RequestMethod.POST)
	public ModelAndView getEmpId(@RequestParam int empId) {
		Employee emp = empService.fetchRecordTbl_Employee(empId);
		AccountInfo info = accService.fetchRecordAccountInfo(empId);
		System.out.println(emp);
		System.out.println(info);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("emp_details");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		return mav;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomepage() {
		return "enter_nameaddress";
	}

	@RequestMapping(value = "fillNewEmpDataForm", method = RequestMethod.POST)
	public String saveEmployeeDetails(@RequestParam int empId) {
		return "enter_new_emp_details";
	}

	/*@RequestMapping(value="getNewDetails" ,method = RequestMethod.POST) 
	 public String saveSalaryAndLocation(@RequestParam String empName,@RequestParam String profile,@RequestParam String address,@RequestParam String
	  location,@RequestParam int salary) {
	  
	 Employee empInfo = new Employee(); empInfo.setDesignation(designation);
	 empInfo.setLocation(location); empInfo.setSalary(salary);
	 
	 empService.addEmployeeDLS(empInfo);
	 
	  return "thanku"; }*/

}
