package com.origin.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllRecords() {
		return employeeRepo.findAll();
	}

	@Override
	public void updateDetails(Employee employee) {
		employeeRepo.save(employee);

	}

	@Override
	public void deleteEmployee(int empId) {
		employeeRepo.deleteById(empId);
	}

}
