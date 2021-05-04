package it.prova.pizzastore.web.servlet.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.UtenteDTO;

@Component
public class PrepareRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareRegistrationServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("insert_utente_attr", new UtenteDTO());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

}
