package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.RuoloDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;


@Component
public class ExecuteModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	public ExecuteModificaUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idUtente");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("confermaPassword");
		String[] ruoliParam = request.getParameterValues("ruolo.id");
		
		boolean isTheLast = utenteService.isTheLastAdministrator(Long.parseLong(idParam));
		
		Utente utentePreModifica = utenteService.caricaSingoloElemento(Long.parseLong(idParam));

		UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromParams(nomeParam, cognomeParam, usernameParam,
				passwordParam, RuoloDTO.createRuoloDTOListFromModelList(ruoloService.findByArrayIdParam(ruoliParam)));
		try {

			if (!UtenteDTO.validateUtenteDTOBean(utenteInstance, confermaPasswordParam) || isTheLast) {
				request.setAttribute("utenteDaModificare", utenteInstance);
				request.setAttribute("ruoli_list_attribute", ruoloService.listAllElements());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
				return;
			}
			utenteInstance.setId(Long.parseLong(idParam));
			utenteInstance.setDateCreated(utentePreModifica.getDateCreated());
			utenteInstance.setStato(utentePreModifica.getStato());
			
			utenteService.aggiorna(utenteInstance.buildUtenteModel());

		} catch (RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("utenteDaModificare", utenteInstance);
			request.setAttribute("ruoli_list_attribute", ruoloService.listAllElements());
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
