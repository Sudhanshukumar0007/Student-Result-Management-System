<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
<h2>Add New Student</h2>
<form action="StudentServlet" method="get">
    <input type="hidden" name="action" value="INSERT"/>
    Name: <input type="text" name="name" required/><br/><br/>
    Email: <input type="email" name="email" required/><br/><br/>
    Course: <input type="text" name="course" required/><br/><br/>
    Country: <input type="text" name="country" required/><br/><br/>
    <input type="submit" value="Save"/>
    <a href="index.jsp">Cancel</a>
</form>
</body>
</html>
