package com.example.demo.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingDetails1 {
	@Autowired
	JdbcTemplate jdbcTemplate;
 
	
	public List<StudentDetailsPOJO> getStudentDetails(int rollNum)
	{
		return jdbcTemplate.query("Select * from StudentDetails where StuRollNo = ?", new Object[] {rollNum}, new RowMapper<StudentDetailsPOJO>() {

			@Override
			public StudentDetailsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
			    StudentDetailsPOJO detailsPOJO = new StudentDetailsPOJO();
			    detailsPOJO.setRollNo(rs.getInt(1));
			    detailsPOJO.setFatherName(rs.getString(2));
			    //detailsPOJO.setAddress(rs.getString(3));
				return detailsPOJO;
			}
			
		});
	}
	
	public List<StudentsPOJO> getStudents(int rollNum)
	{
		return jdbcTemplate.query("Select * from Students where StuRoll = ?",new Object[] {rollNum}, new RowMapper<StudentsPOJO>() {

			@Override
			public StudentsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
			   StudentsPOJO pojo = new StudentsPOJO();
			   pojo.setRollNum(rs.getInt(1));
			   pojo.setStuName(rs.getString(2));
			   pojo.setSubject(rs.getString(3));
			   pojo.setObtainedMarks(rs.getFloat(4));
			   pojo.setMaxMarks(rs.getFloat(5));
				return pojo;
			}
			
		});
	}
}
