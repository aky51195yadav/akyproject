package com.origin.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeNewService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EmployeeNew> getStudentDetails(String name, String profile, String address) {

		return jdbcTemplate.query(
				"Select EmpId , Salary from Tbl_Employee where EmpName = ? and Profile =? and Address =? ",
				new Object[] { name, profile, address }, new RowMapper<EmployeeNew>() {

					@Override
					public EmployeeNew mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeNew emp = new EmployeeNew();
						emp.setId(rs.getInt(1));
						emp.setSalary(rs.getInt(2));
						return emp;
					}

				});
	}

	public List<EmployeeNew> getStudentDetails1(String name, String address) {
		return jdbcTemplate.query("Select EmpId , Salary from Tbl_Employee where EmpName = ? and Address =? ",
				new Object[] { name, address }, new RowMapper<EmployeeNew>() {

					@Override
					public EmployeeNew mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeNew emp = new EmployeeNew();
						emp.setId(rs.getInt(1));
						emp.setSalary(rs.getInt(2));

						return emp;
					}

				});

	}

	public List<EmployeeNew> getStudentDetails2(String name, String profile) {

		return jdbcTemplate.query("Select EmpId , Salary from Tbl_Employee where EmpName = ? and Profile =? ",
				new Object[] { name, profile }, new RowMapper<EmployeeNew>() {

					@Override
					public EmployeeNew mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeNew emp = new EmployeeNew();
						emp.setId(rs.getInt(1));
						emp.setSalary(rs.getInt(2));

						return emp;
					}

				});
	}

	public List<EmployeeNew> getStudentDetails3(String name) {

		return jdbcTemplate.query("Select EmpId , Salary from Tbl_Employee where EmpName = ? ", new Object[] { name },
				new RowMapper<EmployeeNew>() {

					@Override
					public EmployeeNew mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeNew emp = new EmployeeNew();
						emp.setId(rs.getInt(1));
						emp.setSalary(rs.getInt(2));
						return emp;
					}

				});
	}

	public List<EmployeeNew> getDetails() {

		return jdbcTemplate.query("Select * from Tbl_Employee", new RowMapper<EmployeeNew>() {

			@Override
			public EmployeeNew mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeNew emp = new EmployeeNew();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setProfile(rs.getString(3));
				emp.setSalary(rs.getInt(4));
				emp.setAddress(rs.getString(5));
				return emp;
			}

		});

	}
}
