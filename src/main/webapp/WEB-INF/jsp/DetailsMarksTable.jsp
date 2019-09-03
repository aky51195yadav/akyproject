
<%@page import="com.example.demo.app.StudentDetailsPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div{
     margin-top: 30px;
     align-content: center;
     overflow: auto;
}
h1{
   color: blue;
}
th
{
 background-color: silver;
 padding: 7px;
}
td{
    padding: 5px;
}
</style>
</head>
<body>

<h1><i>Student Details</i></h1>
<!--  ${sd}-->

<table border=2>
      <tr>
      <th>StuRoll</th>
      <th>StuName</th>
      </tr>
              
  
      <tr>
      <td>${sd.rollno}</td>
      <td>${sd.name}</td>
      </tr>  
     
</table>
<div>

<h1>Student Marks</h1>
<table border="2" >
      <tr>
      <th>Subject</th>
      <th>ObtainedMarks</th>
      <th>MaxMarks</th>
      </tr>
        
        <c:forEach  items="${stulist}" var="list">
        <tr>
        <td>${list.subject}</td>
        <td>${list.maxmarks}</td>
        <td>${list.obtmarks}</td>
        </tr>
        </c:forEach>
</table>
 
 <h1>Student Percentage</h1> 
<table border="2">
        <tr>
        <th>Percentage</th>
        </tr>
        <tr>
         <td>${sdp.percentage}</td>
        </tr>
</table>
  </div>  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      <!--<td style="padding: 10px">${sd.rollno}</td>
      <td>${sd.name}</td>
      <td>${sd.subject}</td>
      <td>${sd.maxmarks}</td>
      <td>${sd.obtmarks}</td>-->
     
      
     <!--<div>
      <h1><i>Students Marks</i></h1>
      <table border="2">
      <tr>
      <th style="padding: 10px">RollNo</th>
      <th>Mathematics</th>
      <th>English</th>
      <th>Hindi</th>
      <th>Science</th>
      <th>Physics</th>
      <th>Chemistry</th>
      <th>Boilogy</th>
      <th>Max. Marks</th>
      <th>Obtained Marks</th>
      <th>Percentage</th>
      </tr>
       
      <tr>
      <td style="padding: 10px">${sm.rollno}</td>
      <td>${sm.maths}</td>
      <td>${sm.english}</td>
      <td>${sm.hindi}</td>
      <td>${sm.science}</td>
      <td>${sm.physics}</td>
      <td>${sm.chemistry}</td>
      <td>${sm.biology}</td>
      <td>${sm.maxmarks }</td>
      <td>${sm.obtainedmarks}</td>
      <td>${sm.percentage}</td>
      </tr>
      </table>
      </div>-->
</body>
</html>