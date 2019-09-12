<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
table {
	border: 2px solid;
	border-collapse: collapse;
}

th {
	border: 1px solid;
	padding-right: 25px;
	padding-top: 10px;
	text-align: center;
	background-color: windowframe;
}

td {
	border: 1px solid;
	padding-right: 25px;
	padding-top: 10px;
	text-align: center;
	background-color: silver;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Employee Details</h2>
		<table>
			<tr>
				<th>Employee Id</th>
				<th>Employee Salary</th>
				<th>Select</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.salary}</td>
					<td>
					<form action="http://localhost:9021/HibernateTest/boxId" method="post">
					  <input type="text" name="empId" value="${list.id}">
					  <input type="checkbox">
					  </form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>