package com.origin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public void saveEmployee(Employee employee) {
		System.out.println(employee);
		employeeRepo.save(employee);

		System.out.println("object printed");
	}
}
