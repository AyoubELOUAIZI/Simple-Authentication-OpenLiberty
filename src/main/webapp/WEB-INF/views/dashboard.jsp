<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="estm.dsic.jee.model.User" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.servlet.ServletException" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>

<h1>Dashboard Page</h1>
<%
    // try {
        User user = (User) session.getAttribute("user");
        // if (user != null) {
%>

          //   <h2>Welcome to Dashboard</h2>
           //  <p>Welcome, <%= user.getUsername() %>!</p>
           //  <p>Email: <%= user.getEmail() %></p>
<%
    //     } else {
    //         response.sendRedirect("page/login"); // Redirect to login if user is not authenticated
    //     }
    // } catch (IOException | ServletException e) {
    //     // Proper error handling
    //     e.printStackTrace(); // Log the exception for debugging
    //     out.println("<p>An unexpected error occurred. Please try again later.</p>");
    // }
%>
</body>
</html>
