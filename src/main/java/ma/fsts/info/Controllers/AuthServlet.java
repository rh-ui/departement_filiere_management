package ma.fsts.info.Controllers;

import java.io.IOException;

// import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.fsts.info.Services.UsersService;

/**
 * Servlet implementation class AuthServlet
 */

public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private final String HOME_PAGE = "./index.jsp";
	private final String LOGIN_PAGE = "./login.jsp";
	// private final String USR = "redhat";
	// private final String PSSWD = "123";

	/**
	 * Default constructor.
	 */
	public AuthServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(LOGIN_PAGE);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		

		// // Récupérer les paramètres envoyés depuis le formulaire de connexion
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");

		// // Vérifier les informations d'identification
		// if (USR.equals(username) && PSSWD.equals(password)) {
		// 	// Créer une session pour l'utilisateur
		// 	HttpSession session = request.getSession();
		// 	session.setAttribute("username", username);

		// 	// Rediriger vers la page d'accueil
		// 	response.sendRedirect(HOME_PAGE);
		// } else {
		// 	// Si l'authentification échoue, renvoyer à la page de connexion avec un message d'erreur
		// 	request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect");
		// 	request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
		// }

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int id;

		if ((id = UsersService.getUsers(username, password)) != -1) {
			// Create new session :
			HttpSession session = request.getSession();
			// session.setAttribute("idUser", id);
			session.setAttribute("username", username);

			response.sendRedirect(HOME_PAGE);
		}
		else{
			request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect.");
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
		}

	}

}
