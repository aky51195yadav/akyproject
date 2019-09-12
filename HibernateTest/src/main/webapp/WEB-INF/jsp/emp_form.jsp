<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
input {
	border-bottom-width: 5px;
}

td {
	padding-bottom: 10px;
	font-size: larger;
}

#tbl {
	border: 2px solid;
	padding: 20px 20px 20px 20px;
}

a {
	text-decoration: none;
	color: blue;
	font-size: large;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>${message}</h3>
	</div>
	<br />
	<div align="center">
		<form action="http://localhost:9021/HibernateTest/save" method="post" enctype="multipart/form-data">
			<h2>Enter Employee Details</h2>
			<table id="tbl">

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" required="required"
						placeholder="Enter name"></td>
				</tr>
				<tr>
					<td>Profile:</td>
					<td><input type="text" name="profile" required="required"
						placeholder="Enter profile"></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="number" name="salary" required="required"
						placeholder="Enter salary"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" required="required"
						placeholder="Enter address"></td>
				</tr>
				<tr>
				<td>Image</td>
				<td><input type="file" name="image" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save Details" /></td>
			</table>

		</form>
	</div>

	<div align="center">
		<h2>To get All Employees</h2>
		<a href="http://localhost:9021/HibernateTest/showAll"><i>Click
				Here</i></a>
	</div>

</body>
</html>