package estm.dsic.jee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/*")
public class PageForwardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract the page name from the URL path
        String page = request.getPathInfo().substring(1);

        // Forward the request to the appropriate JSP file
        request.getRequestDispatcher("/WEB-INF/views/" + page + ".jsp").forward(request, response);
    }
}

