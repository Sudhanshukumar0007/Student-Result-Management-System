<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.studentms.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
</head>
<body>
<%
    Student s = (Student) request.getAttribute("student");
%>
<h2>Edit Student</h2>

<form action="StudentServlet" method="get">
    <input type="hidden" name="action" value="UPDATE"/>
    <input type="hidden" name="id" value="<%= s.getId() %>"/>

    Name: <input type="text" name="name" value="<%= s.getName() %>" required/><br/><br/>
    Email: <input type="email" name="email" value="<%= s.getEmail() %>" required/><br/><br/>
    Course: <input type="text" name="course" value="<%= s.getCourse() %>" required/><br/><br/>
    Country: <input type="text" name="country" value="<%= s.getCountry() %>" required/><br/><br/>

    <input type="submit" value="Update"/>
    <a href="StudentServlet?action=LIST">Cancel</a>
</form>
</body>
</html>
