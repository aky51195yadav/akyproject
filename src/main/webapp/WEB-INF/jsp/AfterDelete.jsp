<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Updated Records</h1>
 
<table border="2">
<tr>
<th>Student Name</th>
<th>Roll No</th>
</tr>

<tr>
<td>${sd.rollNum}</td>
<td>${sd.stuName}</td>
</tr>

</table>
<table border="2">
<tr>
<th>Subject</th>
<th>Obtained Marks</th>
<th>Max Marks</th>
</tr>
<c:forEach items="${lists}" var="list">
			<tr>
				<td>${list.subject}</td>
				<td>${list.obtainedMarks}</td>
				<td>${list.maxMarks}</td>
			</tr>
		</c:forEach>

</table>

</body>
</html>