<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="estm.dsic.jee.model.User" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome to Dashboard</h2>
    <% 
        HttpSession session = request.getSession(false); // Retrieve session without creating a new one
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
    %>
                <p>Welcome, <%= user.getUsername() %>!</p>
                <p>Email: <%= user.getEmail() %></p>
    <% 
            } else {
                response.sendRedirect("login.jsp"); // Redirect to login if user is not authenticated
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if session is not available
        }
    %>
</body>
</html>
