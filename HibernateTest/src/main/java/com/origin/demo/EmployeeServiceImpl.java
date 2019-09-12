package com.origin.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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
		File file = null;
		file = new File("E:\\Ankit Yadav\\DatabaseImages", image.getOriginalFilename());
		try {
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file = new File("E:\\Ankit Yadav\\DatabaseImages", "image");
		System.out.println(file.length());
		byte[] fileByte = new byte[(int) file.length()];
		System.out.println(fileByte);

		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
