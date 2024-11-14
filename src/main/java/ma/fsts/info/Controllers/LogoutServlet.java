package ma.fsts.info.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Récupère la session en cours
        if (session != null) {
            session.invalidate(); // Invalide la session pour déconnecter l'utilisateur
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp"); // Redirige vers la page de login
    }
}
