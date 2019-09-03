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
	{   try {   
		details.getFileStream();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
			return "RollNoPage";
	}
	
	
	
	/*@RequestMapping(value = "datapage", method = RequestMethod.POST)
	public ModelAndView studentDataPage(@RequestParam int rollnumber)
	{
	      List<StudentDetailsPOJO> list = details.getStudentsDetails(rollnumber); 
	      float totalMarks=0 , totalMaxMarks=0;
	      StudentDetailsPOJO studentDetailsPOJO = null;
	      for (int i = 0; i < list.size(); i++) {
          studentDetailsPOJO = list.get(i);
          totalMaxMarks = totalMaxMarks + studentDetailsPOJO.getMaxmarks();
          totalMarks = totalMarks + studentDetailsPOJO.getObtmarks();
	      }
	      float percentage = ((totalMarks*100)/(totalMaxMarks));
	      studentDetailsPOJO.setPercentage(percentage);
	      //float percentage = (totalMarks*100)/(studentDetailsPOJO.get)
	      //System.out.println(list);
	       StudentDetailsPOJO studentDetailsPOJO1 =  list.get(0);
	     // System.out.println(studentDetailsPOJO1.getSubject());
	      //List<StudentMarksPOJO> list1 = details.getStudentMarks(rollnumber);
	      //StudentMarksPOJO studentMarksPOJO = list1.get(0);
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("DetailsMarksTable");
		  modelAndView.addObject("stulist", list);
		  modelAndView.addObject("sd", studentDetailsPOJO1);
		  modelAndView.addObject("sdp", studentDetailsPOJO);
		  return modelAndView;
	}*/
	/*@RequestMapping(value = "savedData", method = RequestMethod.POST)
	public String addDataDetails(@RequestParam int rollnumber)
	{   
		List<StudentDetailsPOJO> list = details.getStudentsDetails(rollnumber);
		return "SendDetailsToDatabase";
		
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
