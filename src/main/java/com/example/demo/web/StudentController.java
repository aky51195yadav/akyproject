package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "stuCon")
public class StudentController {
	@Autowired
	MappingDetails2 details;

	@RequestMapping(value = "fetchRoll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Student getRoll(@RequestParam int rollNum) {
		System.out.println(rollNum);
		List<Student> list = details.getStudentsDetails(rollNum);
		List<Marks> list1 = details.getStudents(rollNum);
		Student stu = list.get(0);
		stu.setResult(list1);
		return stu;
	}
}
