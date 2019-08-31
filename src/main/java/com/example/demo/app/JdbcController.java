
package com.example.demo.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JdbcController {
	@Autowired
	JdbcTemplate jdbc;
	@RequestMapping(value = "create", method = RequestMethod.GET)
	@ResponseBody
	public String createTable() {
		jdbc.execute("insert into employee values(21, 'yadav', 7777777, 'Noida')");
		return "Table Created Successfully";
	}
}
