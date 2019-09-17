package com.origin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.origin.web.Employee;
import com.origin.web.Expenses;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllRecords();

	void updateDetails(Employee employee);

	void deleteEmployee(int empId);

	void imageWork(MultipartFile image);

	Employee fetchRecord(String name, String address);

	Employee fetchRecordTbl_Employee(int empId);

	boolean pwdValidation(String password);

	boolean userValidation(String userName);

	Employee fetchUser(String userName, String password);

}
