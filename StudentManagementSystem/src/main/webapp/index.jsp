<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f4; }
        .container {
            width: 70%; margin: 80px auto; background: white; padding: 40px;
            border-radius: 10px; box-shadow: 0 2px 15px rgba(0,0,0,0.2);
        }
        h1 { color: #333; }
        .btn {
            padding: 12px 20px; margin: 10px 5px;
            background: #0066cc; color: white; border: none;
            border-radius: 6px; text-decoration: none; font-size: 16px;
        }
        .btn:hover { background: #004d99; }
    </style>
</head>
<body>
<div class="container">
    <h1>Student Management System</h1>
    <p>Current time: <strong><%= new java.util.Date() %></strong></p>

    <a href="StudentServlet?action=NEW" class="btn">Add Student</a>
    <a href="StudentServlet?action=LIST" class="btn">View Students</a>
</div>
</body>
</html>
