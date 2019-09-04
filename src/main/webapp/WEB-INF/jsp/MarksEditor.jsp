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
    <form action="http://localhost:9021/logs/editedmarks" method="post">
     <input type="hidden" name="rollNum" value ="${rollNum}" readonly="readonly">
     <input type="hidden" name="stuName" value ="${stuName}" readonly="readonly">
      Subject: <input type="text" name="subject" value="${subject}" readonly="readonly">
      Obtained Marks: <input type="number" name="obtainedMarks" value="${obtMarks}" required="required">
      Max Marks: <input type="number" name="maxMarks" value="${maxMarks}" readonly="readonly">
      <input type="Submit">
    </form>
</body>
</html>