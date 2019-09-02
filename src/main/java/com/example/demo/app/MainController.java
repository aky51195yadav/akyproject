package com.example.demo.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	//@Autowired
	//private LoginService logservice;
	 @Autowired
	 MappingDetails details;
	
	@RequestMapping(value = "rollpage", method = RequestMethod.GET) 
	public String rollnoPage()
	{
			return "RollNoPage";
	}
	
	@RequestMapping(value = "datapage", method = RequestMethod.POST)
	public ModelAndView studentDataPage(@RequestParam int rollnumber)
	{
	      List<StudentDetailsPOJO> list = details.getStudentsDetails(rollnumber);
	      List<StudentMarksPOJO> list1 = details.getStudentMarks(rollnumber);
	      StudentDetailsPOJO studentDetailsPOJO =  list.get(0);
		  System.out.println(studentDetailsPOJO);
	      StudentMarksPOJO studentMarksPOJO = list1.get(0);
		  System.out.println(studentMarksPOJO);
		  System.out.println(studentMarksPOJO.getMaxmarks());
		  System.out.println(studentMarksPOJO.getObtainedmarks());
		  System.out.println(studentMarksPOJO.getPercentage());
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("DetailsMarksTable");
		  modelAndView.addObject("sd", studentDetailsPOJO);
		  modelAndView.addObject("sm",studentMarksPOJO);
		  return modelAndView;
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "LoginPage";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean service = logservice.userValidation(name, password);

		if (!service) {
			model.put("errormessage", "You have entered wrong details");
			return "LoginPage";
		}
		return "WelcomePage";
	}
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public String showData() {
		return "LoginPage";
	}*/

}
