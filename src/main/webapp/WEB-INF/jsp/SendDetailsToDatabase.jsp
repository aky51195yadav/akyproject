<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.app.StudentDetailsPOJO" %>
    <%@page import="com.example.demo.app.StudentsPOJO" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Subject and Marks</h1>
   
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
  <table border="2">
   <tr>
   <th>Student Name</th>
   <th>Subject</th>
   </tr>
  <c:forEach items="${lists1}" var="list">
    <tr>
    <td>${list.subject}</td>
     
    </tr>  
    </c:forEach>
  </table>
  
   <table border="2">
   <tr>
   <th>Student Name</th>
   <th>Subject</th>
   </tr>
  
    <tr>
     <td>${sname.stuName}</td>
     
    </tr>  
   
  </table>
</body>
</html>