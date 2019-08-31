package com.example.demo.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingDetails {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<StudentDetailsPOJO> getStudentsDetails(int rollnumber)
	{
		
		 return jdbcTemplate.query("Select * from StudentDetails where StuRollNo =  ?",new Object[] {rollnumber}, new RowMapper<StudentDetailsPOJO>(){
			@Override
			public StudentDetailsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentDetailsPOJO detailsPOJO = new StudentDetailsPOJO();
				detailsPOJO.setRollno(rs.getInt(1));
				detailsPOJO.setName(rs.getString(2));
				detailsPOJO.setFname(rs.getString(3));
				detailsPOJO.setAddress(rs.getString(4));
				return detailsPOJO;
			}
			
		});
	}
    public List<StudentMarksPOJO> getStudentMarks()
    {
    	String query = "Select * from StudentMarks";
    	return jdbcTemplate.query(query, new RowMapper<StudentMarksPOJO>() {

			@Override
			public StudentMarksPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentMarksPOJO marksPOJO = new StudentMarksPOJO();
				marksPOJO.setMaths(rs.getInt(1));
				marksPOJO.setEnglish(rs.getInt(1));
				marksPOJO.setHindi(rs.getInt(1));
				marksPOJO.setScience(rs.getInt(1));
				marksPOJO.setPhysics(rs.getInt(1));
				marksPOJO.setChemistry(rs.getInt(1));
				marksPOJO.setBiology(rs.getInt(1));
				marksPOJO.setMaxmarks(rs.getInt(1));
				return marksPOJO;
			}
    		
    	});
    }
    
    
}
