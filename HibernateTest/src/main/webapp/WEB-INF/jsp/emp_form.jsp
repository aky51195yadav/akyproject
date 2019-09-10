<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:9021/HibernateTest/fetchDetails"
		method="post">
		Name: <input type="text" name="name" required="required">
		Profile: <input type="text" name="profile" required="required">
		Salary: <input type="number" name="salary" required="required">
		Address:<input type="text" name="address" required="required">
		<input type="submit" value="Submit Details" />
	</form>
</body>
</html>