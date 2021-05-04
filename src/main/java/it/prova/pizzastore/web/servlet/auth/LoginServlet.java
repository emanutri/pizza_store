package it.prova.pizzastore.web.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.UtenteService;
import it.prova.pizzastore.web.filter.AuthenticationFilter;

@Component
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new UnsupportedOperationException("Invocation of doGet not allowed for this Servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operationResult = request.getParameter("successResult");
		if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		
		String loginInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");

		if (StringUtils.isEmpty(loginInput) || StringUtils.isEmpty(passwordInput)) {
			request.setAttribute("errorMessage", "E' necessario riempire tutti i campi.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		String destinazione = null;

		try {
			Utente utenteInstance = utenteService.eseguiAccesso(loginInput, passwordInput);
			if (utenteInstance == null) {
				destinazione = "login.jsp";
				request.setAttribute("errorMessage", "Utente non trovato.");
			} else {
				AuthenticationFilter.putUserLoggedInSession(request, utenteInstance);
				destinazione = "home";
			}
		} catch (Exception e) {
			e.printStackTrace();
			destinazione = "login.jsp";
			request.setAttribute("errorMessage", "Attenzione! Si è verificato un errore.");
		}

		request.getRequestDispatcher(destinazione).forward(request, response);

	}

}
