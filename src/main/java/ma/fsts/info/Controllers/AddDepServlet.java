package ma.fsts.info.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fsts.info.Models.Departement;
import ma.fsts.info.Services.DepartementService;

public class AddDepServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public AddDepServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartementService ds = new DepartementService();

        if (request.getParameter("idEditDep") != null) {
            String idParam = request.getParameter("idEditDep");
            int id = Integer.parseInt(idParam);
            Departement dep = ds.getById(id);
            request.setAttribute("department", dep);
            request.getRequestDispatcher("/editDepartment.jsp").forward(request, response);
        } else if (request.getParameter("idDeleteDep") != null) {
            String idParam = request.getParameter("idDeleteDep");
            int id = Integer.parseInt(idParam);
            ds.delete(ds.getById(id));
            response.sendRedirect(request.getContextPath() + "/depController");
        } else {
            response.sendRedirect(request.getContextPath() + "/addDepartment.jsp");
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        DepartementService ds = new DepartementService();

        Departement department = null;


        String action = request.getParameter("action");
        if ("editDep".equals(action)) {
            // Mise à jour d'une filière existante
            int id = Integer.parseInt(request.getParameter("idEditDep"));
            department = new Departement(id, name);
            ds.updateDep(department);
        }

        if ("addDep".equals(action)) {
            department = new Departement(0, name);
            ds.addDep(department);
        }
        
        response.sendRedirect(request.getContextPath() + "/depController");

    }

}
