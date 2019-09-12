package com.origin.demo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllRecords();

	void updateDetails(Employee employee);

	void deleteEmployee(int empId);

	void imageWork(MultipartFile image);
}
