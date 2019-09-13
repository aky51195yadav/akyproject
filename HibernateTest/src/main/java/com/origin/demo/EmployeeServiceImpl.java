package com.origin.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void imageWork(MultipartFile image) {
		 String fileName = image.getOriginalFilename();
		 File file = new File("E:\\Ankit Yadav\\DatabaseImages", fileName);
		try {
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
      
	}

	@Override
	public Employee fetchRecord(String name, String address) {
		return employeeRepo.findByNameAndAddress(name, address);

	}

	@Override
	public Employee fetchRecordTbl_Employee(int empId) {

		Optional<Employee> option = employeeRepo.findById(empId);
		if (option.isPresent()) {

			return option.get();

		}
		return new Employee();

	}

}
