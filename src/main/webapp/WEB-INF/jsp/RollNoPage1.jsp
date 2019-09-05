<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Enter Student Roll No</h3>
	<form action="http://localhost:9021/logs/savedata" method="post">
		RollNo : <input type="number" name="rollNum"
			placeholder="Enter roll no" required="required"> <input
			type="submit">
	</form>
	<form action="http://localhost:9021/logs/loadExcel" method="post"
		enctype="multipart/form-data" style="padding: 50px">
		File : <input type="file" name="mf" required="required"> <input
			type="submit" value="Upload File">
	</form>
	
    <form action="http://localhost:9021/logs/stuCon/fetchRoll" method="post">
		RollNo : <input type="number" name="rollNum"
			placeholder="Enter roll no" required="required"> <input
			type="submit" value="For Api">
	</form>
	
</body>
</html>