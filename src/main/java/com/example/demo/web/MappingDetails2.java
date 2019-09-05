package com.example.demo.web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingDetails2 {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> getStudentsDetails(int rollnumber) {
		return jdbcTemplate.query("Select * from StudentDetails where StuRollNo = ?", new Object[] { rollnumber },
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student stu = new Student();
						stu.setName(rs.getString(1));
						stu.setFather(rs.getString(2));
						stu.setRoll(rs.getString(3));
						return stu;
					}

				});
	}

	public List<Marks> getStudents(int rollnumber) {

		return jdbcTemplate.query("Select * from Students where StuRoll = ?", new Object[] { rollnumber },
				new RowMapper<Marks>() {

					@Override
					public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
						Marks marksPOJO = new Marks();
						marksPOJO.setSubName(rs.getString("Subject"));
						marksPOJO.setMaxMarks(rs.getFloat("ObtainMarks"));
						marksPOJO.setObtMarks(rs.getFloat("MaxMarks"));
						return marksPOJO;
					}

				});
	}

}
