<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.studentms.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        table { border-collapse: collapse; width: 90%; margin: 20px auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #eee; }
    </style>
</head>
<body>
<h2>All Students</h2>

<a href="index.jsp">Home</a> |
<a href="StudentServlet?action=NEW">Add Student</a>
<br/><br/>

<table>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Country</th><th>Actions</th>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("studentList");
        if (list != null) {
            for (Student s : list) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
        <td><%= s.getCountry() %></td>
        <td>
            <a href="StudentServlet?action=EDIT&id=<%= s.getId() %>">Edit</a> |
            <a href="StudentServlet?action=DELETE&id=<%= s.getId() %>"
               onclick="return confirm('Delete this student?');">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
