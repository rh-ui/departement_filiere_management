package ma.fsts.info.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.fsts.info.Services.DepartementService;

public class DepartmentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartementService ds = new DepartementService();
        HttpSession session = request.getSession();

        session.setAttribute("departments", ds.getAll());
        response.sendRedirect("departement.jsp");
    }

}
