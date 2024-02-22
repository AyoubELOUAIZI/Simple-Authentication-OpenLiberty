package estm.dsic.jee.servlets;

import estm.dsic.jee.dao.UserDao;
import estm.dsic.jee.model.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                System.out.println("signup........... ");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User newUser = new User(0, email, username, password); // id is set to 0, it will be auto-generated

        try {
            userDao.addUser(newUser);
            response.sendRedirect("login.jsp"); // Redirect to login page after signup
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error, redirect to error page
            response.sendRedirect("error.jsp");
        }
    }
}
