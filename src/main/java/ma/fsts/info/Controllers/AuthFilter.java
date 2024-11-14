package ma.fsts.info.Controllers;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

                
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Vérifiez si l'utilisateur est connecté (en vérifiant une session existante)
        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

        // L'URL de connexion
        String loginURI = httpRequest.getContextPath() + "/login.jsp";

        // Vérifiez si l'URL est accessible sans connexion (ex. : la page de connexion elle-même)
        boolean isLoginRequest = httpRequest.getServletPath().equals("/login.jsp");

        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn || isLoginRequest || isLoginPage) {
            // Si l'utilisateur est connecté ou s'il essaie d'accéder à la page de connexion
            chain.doFilter(request, response); // Autorisez l'accès
        } else {
            // Sinon, redirigez vers la page de connexion
            httpResponse.sendRedirect(loginURI);
        }
    }

}
