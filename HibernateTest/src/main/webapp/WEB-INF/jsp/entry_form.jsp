<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="http://localhost:9021/HibernateTest/getDetails"
			method="post">
			<h2>Enter Employee Details</h2>
			<table id="tbl">

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" placeholder="Enter name"
						required="required"></td>
				</tr>
				<tr>
					<td>Profile:</td>
					<td><input type="text" name="profile"
						placeholder="Enter profile"></td>
					<!--<td><input type="text" name="myText" value="Norway"
       selectBoxOptions="Canada;Denmark;Finland;Germany;Mexico"> </td>-->
				</tr>
				<!--<tr>
					<td><select id="profile">
							<c:forEach items="${list1}" var="list1">
								<option value="${item.id }">${list1.profile}</option>
							</c:forEach>
					</select></td>
				</tr>-->


				<tr>
					<td>Address:</td>
					<td><select name="address">
							<c:forEach items="${list1}" var="list1">
								<option>${list1.address}</option>
							</c:forEach>
					</select></td>
				</tr>
				<!--<tr>
					<td><select id="address">
							<c:forEach items="${list1}" var="list1">
								<option value="${item.id }">${list1.address}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>-->

				<td><input type="submit" value="Get Details" /></td>
			</table>

		</form>
	</div>

</body>
</html>