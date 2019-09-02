<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div{
     margin-top: 100px;
     align-content: center;
     overflow: auto;
}
h1{
   color: blue;
}
th
{
 background-color: silver;
}
</style>
</head>
<body>
 
<h1><i>Student Details</i></h1>
   <table border=2 , >
      <tr>
      <th style="padding: 10px">StuRoll</th>
      <th>StuName</th>
      <th>Subject</th>
      <th>MaxMarks</th>
      <th>ObtainedMarks</th>
      </tr>
       
      <tr>
      <td style="padding: 10px">${sd.rollno}</td>
      <td>${sd.name}</td>
      <td>${sd.subject}</td>
      <td>${sd.maxmarks}</td>
      <td>${sd.obtmarks}</td>
      </tr>
      </table>
      
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