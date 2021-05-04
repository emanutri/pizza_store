package it.prova.pizzastore.web.servlet.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.service.UtenteService;

@Component
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	public RegistrationServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("passwordRepeat");

		try {
			UtenteDTO utenteInstance = UtenteDTO.registerUtenteDTOFromInsertParams(usernameParam, passwordParam,
					nomeParam, cognomeParam);
			if (!passwordParam.equals(confermaPasswordParam) && passwordParam != null && passwordParam != "") {
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione nella password");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				return;
			}

			utenteInstance.validateRegistration();
			if (utenteInstance.hasErrors()) {
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore!");
				request.setAttribute("insert_utente_attr", utenteInstance);
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				return;
			}

			utenteService.inserisciNuovo(utenteInstance.buildUtenteModel());
			request.setAttribute("successMessage", "Registrazione avvenuta con successo.");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
			return;
		}

		response.sendRedirect(request.getContextPath()+"/HomeServlet?successResult=SUCCESS");
	}

}
