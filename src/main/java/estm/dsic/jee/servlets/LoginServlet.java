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
import javax.servlet.http.HttpSession;

@WebServlet("login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("username: " + email);
        System.out.println("password:"+password);

        UserDao userDao = new UserDao();
        try {
            User user = userDao.getUserByEmailAndPassword(email, password);
           System.out.println("\n\n\nuser: \n{" + user+"\n}");
            if (user != null) {
                // User authenticated, set user session attribute
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("page/dashboard");
            } else {
                // Authentication failed, redirect to error page
                response.sendRedirect("page/login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error, redirect to error page
            response.sendRedirect("page/error");
        }
    }

}
