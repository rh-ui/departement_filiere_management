package ma.fsts.info.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.fsts.info.Models.Filiere;
import ma.fsts.info.Services.DepartementService;
import ma.fsts.info.Services.FiliereService;

public class AddFilServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public AddFilServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FiliereService fs = new FiliereService();
        DepartementService ds = new DepartementService();

        HttpSession session = request.getSession();
        session.setAttribute("departmentsList", ds.getAll());

        // response.sendRedirect(request.getContextPath() + "/addFiliere.jsp");

        if (request.getParameter("idEdit") != null) {
            String idParam = request.getParameter("idEdit");
            int id = Integer.parseInt(idParam);
            Filiere filiere = fs.getById(id);
            request.setAttribute("filiere", filiere);
            request.getRequestDispatcher("/editFiliere.jsp").forward(request, response);
        } else if (request.getParameter("idDelete") != null) {
            String idParam = request.getParameter("idDelete");
            int id = Integer.parseInt(idParam);
            fs.delete(fs.getById(id));
            response.sendRedirect(request.getContextPath() + "/filController");
        } else {
            response.sendRedirect(request.getContextPath() + "/addFiliere.jsp");
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String name = request.getParameter("name");
        int idDep = Integer.parseInt(request.getParameter("idDep"));

        FiliereService fs = new FiliereService();

        Filiere filiere = null;

        if ("edit".equals(action)) {
            // Mise à jour d'une filière existante
            int id = Integer.parseInt(request.getParameter("idEdit"));
            filiere = new Filiere(id, name, idDep);
            fs.modifyF(filiere);
        }

        if ("add".equals(action)) {
            filiere = new Filiere(0, name, idDep);
            fs.add(filiere);
        }

        response.sendRedirect(request.getContextPath() + "/filController");

    }
}
