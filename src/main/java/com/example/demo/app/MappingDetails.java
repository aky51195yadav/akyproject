package com.example.demo.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MappingDetails {
	@Autowired
	StudentDetailsPOJO studentDetailsPOJO;

	StudentMarksPOJO studentMarksPOJO;
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<StudentDetailsPOJO> getStudentsDetails()
	{
		String query = ("Select * from StudentDetails");
		 return jdbcTemplate.query(query, new RowMapper<StudentDetailsPOJO>(){
			@Override
			public StudentDetailsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
			       studentDetailsPOJO.setRollno(rs.getInt(1));
			       studentDetailsPOJO.setName(rs.getString(2));
			       studentDetailsPOJO.setFname(rs.getString(3));
			       studentDetailsPOJO.setAddress(rs.getString(4));
				return studentDetailsPOJO;
			}
			
		});
	}
    public List<StudentMarksPOJO> getStudentMarks()
    {
    	String query = "Select * from StudentMarks";
    	return jdbcTemplate.query(query, new RowMapper<StudentMarksPOJO>() {

			@Override
			public StudentMarksPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
			    studentMarksPOJO.setMaths(rs.getInt(1));
			    studentMarksPOJO.setEnglish(rs.getInt(1));
			    studentMarksPOJO.setHindi(rs.getInt(1));
			    studentMarksPOJO.setScience(rs.getInt(1));
			    studentMarksPOJO.setPhysics(rs.getInt(1));
			    studentMarksPOJO.setChemistry(rs.getInt(1));
			    studentMarksPOJO.setBiology(rs.getInt(1));
			    studentMarksPOJO.setMaxmarks(rs.getInt(1));
				return studentMarksPOJO;
			}
    		
    	});
    }
}
