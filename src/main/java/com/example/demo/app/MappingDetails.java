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
	
	public  List<StudentDetailsPOJO> getStudentsDetails(int rollnumber)
	{
		 return jdbcTemplate.query("Select * from Students where StuRoll = ?" , new Object[] {rollnumber}, new RowMapper<StudentDetailsPOJO>(){
			@Override
			public StudentDetailsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentDetailsPOJO detailsPOJO = new StudentDetailsPOJO();
				detailsPOJO.setRollno(rs.getInt(1));
				detailsPOJO.setName(rs.getString(2));
				detailsPOJO.setSubject(rs.getString(3));
				detailsPOJO.setMaxmarks(rs.getFloat(4));
				detailsPOJO.setObtmarks(rs.getFloat(5));
				//detailsPOJO.setFname(rs.getString(3));
				//detailsPOJO.setAddress(rs.getString(4));
				return detailsPOJO;
			}
			
		});
	}
    /*public List<StudentMarksPOJO> getStudentMarks(int rollnumber)
    {
    	
    	return jdbcTemplate.query("Select * from StudentMarks where StuRollNo = ?" , new Object[] {rollnumber}, new RowMapper<StudentMarksPOJO>() {

			@Override
			public StudentMarksPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentMarksPOJO marksPOJO = new StudentMarksPOJO();
				marksPOJO.setRollno(rs.getInt(1));
				marksPOJO.setMaths(rs.getInt(2));
				marksPOJO.setEnglish(rs.getInt(3));
				marksPOJO.setHindi(rs.getInt(4));
				marksPOJO.setScience(rs.getInt(5));
				marksPOJO.setPhysics(rs.getInt(6));
				marksPOJO.setChemistry(rs.getInt(7));
				marksPOJO.setBiology(rs.getInt(8));
				marksPOJO.setMaxmarks(rs.getInt(9));
				float obtainMarks =rs.getInt(2)+rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+ rs.getInt(6)+rs.getInt(7)+rs.getInt(8);
				marksPOJO.setObtainedmarks(obtainMarks);
				float percentage = (((marksPOJO.getObtainedmarks())*100)/(marksPOJO.getMaxmarks()));
				Float F = percentage;
				String s = F.toString();
				String s1 = s.substring(0,5);
				Float F1 = Float.parseFloat(s1);
				float percentage1 =  F1.floatValue();
				marksPOJO.setPercentage(percentage1);
				return marksPOJO;
			}
    		
    	});
    }*/
    
    
}
