package com.example.demo.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingDetails1 {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<StudentDetailsPOJO> getStudentDetails(int rollNum) {
		return jdbcTemplate.query("Select * from StudentDetails where StuRollNo = ?", new Object[] { rollNum },
				new RowMapper<StudentDetailsPOJO>() {

					@Override
					public StudentDetailsPOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentDetailsPOJO detailsPOJO = new StudentDetailsPOJO();
						detailsPOJO.setRollNo(rs.getInt(1));
						detailsPOJO.setFatherName(rs.getString(2));
						// detailsPOJO.setAddress(rs.getString(3));
						return detailsPOJO;
					}

				});
	}

	public List<StudentsPOJO> getStudents(int rollNum) {
		return jdbcTemplate.query("Select * from Students where StuRoll = ?", new Object[] { rollNum },
				new RowMapper<StudentsPOJO>() {

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

	public Boolean saveToDatabase(StudentsPOJO studentsPOJO) {
		String query = "insert into Students values(?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, studentsPOJO.getRollNum());
				ps.setString(2, studentsPOJO.getStuName());
				ps.setString(3, studentsPOJO.getSubject());
				ps.setFloat(4, studentsPOJO.getObtainedMarks());
				ps.setFloat(5, studentsPOJO.getMaxMarks());
				return ps.execute();
			}
		});
	}

	public int marksUpdated(float obtainedMarks, String subject, int rollNum) {

		String query = "update Students set ObtainMarks = ? where Subject= ? and StuRoll= ? ";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setFloat(1, obtainedMarks);
				ps.setString(2, subject);
				ps.setInt(3, rollNum);
				return ps.executeUpdate();
			}
		});
	}

	public float percentage(List<StudentsPOJO> list) {
		float percentage = 0;
		float maxMarks = totalMaxMarks(list);
		float obtMarks = totalObtMarks(list);
		percentage = (obtMarks * 100) / (maxMarks);
		return percentage;
	}

	public float totalMaxMarks(List<StudentsPOJO> list) {
		float maxMarks = 0;
		for (StudentsPOJO studentsPOJO : list) {
			maxMarks = maxMarks + studentsPOJO.getMaxMarks();
		}
		return maxMarks;
	}

	public float totalObtMarks(List<StudentsPOJO> list) {
		float obtMarks = 0;
		for (StudentsPOJO studentsPOJO : list) {
			obtMarks = obtMarks + studentsPOJO.getObtainedMarks();
		}
		return obtMarks;
	}

	public int recordDelete(int rollNum, String stuName, String subject) {
		String query = "delete from Students where StuRoll = ? and StuName = ? and Subject = ?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, rollNum);
				ps.setString(2, stuName);
				ps.setString(3, subject);
				return ps.executeUpdate();
			}

		});
	}

	public List<StudentsPOJO> readFile(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<StudentsPOJO> list = new ArrayList<>();

		try {
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("Sheet1");
			int i = sheet.getLastRowNum();

			for (int j = 1; j <= i; j++) {

				Row row = sheet.getRow(j);
				int rollNum = (int) (row.getCell(0).getNumericCellValue());
				String stuName = row.getCell(1).getStringCellValue();
				String subject = row.getCell(2).getStringCellValue();
				float obtainedMarks = (float) (row.getCell(3).getNumericCellValue());
				float maxMarks = (float) row.getCell(4).getNumericCellValue();

				StudentsPOJO pojo = new StudentsPOJO();
				pojo.setRollNum(rollNum);
				pojo.setStuName(stuName);
				pojo.setSubject(subject);
				pojo.setObtainedMarks(obtainedMarks);
				pojo.setMaxMarks(maxMarks);
				System.out.println(pojo);
				list.add(pojo);
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Wrong way to insert a list to database.

	/*
	 * public void saveExcelToDatabase(List<StudentsPOJO> list) { for (int i = 0; i
	 * < list.size(); i++) { StudentsPOJO pojo = list.get(i); String query =
	 * "insert into Students values(?,?,?,?,?)"; jdbcTemplate.execute(query, new
	 * PreparedStatementCallback<Integer>() {
	 * 
	 * @Override public Integer doInPreparedStatement(PreparedStatement ps) throws
	 * SQLException, DataAccessException { ps.setInt(1,pojo.getRollNum());
	 * ps.setString(2, pojo.getStuName()); ps.setString(3, pojo.getSubject());
	 * ps.setFloat(4, pojo.getObtainedMarks()); ps.setFloat(5, pojo.getMaxMarks());
	 * return ps.executeUpdate();
	 * 
	 * } }); }
	 * 
	 * }
	 */

	public int[] saveExcelToDatabase(List<StudentsPOJO> list) {
		return jdbcTemplate.batchUpdate("insert into Students values(?,?,?,?,?)", new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, list.get(i).getRollNum());
				ps.setString(2, list.get(i).getStuName());
				ps.setString(3, list.get(i).getSubject());
				ps.setFloat(4, list.get(i).getObtainedMarks());
				ps.setFloat(5, list.get(i).getMaxMarks());
			}

			@Override
			public int getBatchSize() {

				return list.size();
			}
		});
	}

}
