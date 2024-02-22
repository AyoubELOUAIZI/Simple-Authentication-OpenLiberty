<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="estm.dsic.jee.model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.servlet.ServletException" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<%
 User user = (User) session.getAttribute("user");
    if (user != null) {
         response.sendRedirect("/web02/page/dashboard"); // Redirect to login if user is not authenticated
        return; 
    }

%>
    <h2>Login</h2>
    <form action="/web02/login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
