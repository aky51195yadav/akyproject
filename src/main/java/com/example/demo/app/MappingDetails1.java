package com.example.demo.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
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
	
	public Boolean saveToDatabase(StudentsPOJO studentsPOJO)
	{
		String query = "insert into Students values(?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setInt(1, studentsPOJO.getRollNum());
				ps.setString(2, studentsPOJO.getStuName());
				ps.setString(3, studentsPOJO.getSubject());
				ps.setFloat(4, studentsPOJO.getObtainedMarks());
				ps.setFloat(5,  studentsPOJO.getMaxMarks());
				return ps.execute();
			}
		});
	}
	public float percentage(List<StudentsPOJO> list)
	{
	    float percentage = 0;
		float maxMarks =  totalMaxMarks(list);
		float obtMarks = totalObtMarks(list);
	    percentage = (obtMarks*100)/(maxMarks);
	    return percentage;
	}
	
	public float totalMaxMarks(List<StudentsPOJO> list)
	{    
		     float maxMarks = 0;
		     for (StudentsPOJO studentsPOJO : list) {
			 maxMarks =  maxMarks + studentsPOJO.getMaxMarks();
		}
		return maxMarks;
	}
	
	public float totalObtMarks(List<StudentsPOJO> list)
	{
		    float obtMarks = 0;
		    for (StudentsPOJO studentsPOJO : list) {
			obtMarks = obtMarks +  studentsPOJO.getObtainedMarks();
		}
		return obtMarks;
	}
	
	
}
