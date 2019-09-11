package com.origin.demo;

import java.util.List;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllRecords();

	void updateDetails(Employee employee);

	void deleteEmployee(int empId);
}
