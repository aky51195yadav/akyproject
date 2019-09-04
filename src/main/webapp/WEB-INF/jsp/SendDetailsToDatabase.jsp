<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
form {
	margin-top: 25px;
}

div {
	margin-top: 20px;
}

table {
	border: 2px solid;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Details</h1>

	<table border="2">
		<tr>
			<th>Roll No</th>
			<th>Father Name</th>
		</tr>
		<c:forEach items="${lists}" var="list">
			<tr>
				<td>${list.rollNo}</td>
				<td>${list.fatherName}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<h1>Student Name</h1>
		<table border="2">
			<tr>
				<th>Student Name</th>
			</tr>
			<tr>
				<td>${sd.stuName}</td>
			</tr>
			</div>
		</table>

		<h1>Student Marks</h1>
		<table border="2">
			<tr>
				<th>Subject</th>
				<th>Obtained Marks</th>
				<th>Max Marks</th>
			</tr>
			<c:forEach items="${lists1}" var="list">
				<tr>
					<td >${list.subject}</td>
					<td>${list.obtainedMarks}</td>
					<td>${list.maxMarks}</td>
					<td>  <form action="http://localhost:9021/logs/editmarks" method="post">
					<input type="hidden" name="subject" value="${list.subject}">
					<input type="hidden" name="obtainedMarks" value="${list.obtainedMarks}">
					<input type="hidden" name="maxMarks" value="${list.maxMarks}">
					<input type="hidden" name="rollNum" value="${list.rollNum}">
					<input type="hidden" name="stuName" value="${list.stuName}">
					   <input type="submit" value="Edit Marks" >
					</form></td>
				</tr>
			</c:forEach>
		</table>
		<h1>Final Results</h1>
		<table border="2">
			<tr>
				<th>Total Obtained</th>
				<th>Total Max Marks</th>
				<th>Percentage</th>
			</tr>
			<tr>
				<td>${stotal.totalObtMarks}</td>
				<td>${stotal.totalMaxMarks}</td>
				<td>${stotal.percentage}</td>
			</tr>
		</table>
		<h1>Add more Details</h1>
		<form action="http://localhost:9021/logs/savefetcheddata"
			method="post">
			<input type="hidden" name="rollNum" value="${sd.rollNum}"> <input
				type="hidden" name="stuName" value="${sd.stuName}">
			Subject: <input type="text" name="subject"
				placeholder="Enter new subjects" required="required">
			Obtained Marks: <input type="number" name="obtMarks"
				placeholder="Enter obtained marks" required="required"> Max
			Marks:<input type="number" name="maxMarks"
				placeholder="Enter max marks" required="required"> <input
				type="submit" value="Submit Details" required="required">
		</form>
</body>
</html>