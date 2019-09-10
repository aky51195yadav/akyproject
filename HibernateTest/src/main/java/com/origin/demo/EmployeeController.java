package com.origin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "dataForm", method = RequestMethod.GET)
	public String fillDetails() {
		return "emp_form";
	}

	@RequestMapping(value = "fetchDetails", method = RequestMethod.POST)
	public String empDetails(@RequestParam String name, @RequestParam String profile, @RequestParam int salary,
			@RequestParam String address) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		System.out.println(name);
		empService.saveEmployee(employee);
		System.out.println(name);
		return "NewFile";
	}

}
