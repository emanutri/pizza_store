package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;
import java.util.List;

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
public class ExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	public ExecuteSearchUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String dataCreazioneParam = request.getParameter("dateCreated");
		String statoParam = request.getParameter("stato");
		String[] ruoloParam = request.getParameterValues("ruolo.id");
		
		try {
			
			UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromParams(usernameParam, nomeParam, cognomeParam,
					dataCreazioneParam, statoParam, RuoloDTO.createRuoloDTOListFromModelList(ruoloService.findByArrayIdParam(ruoloParam)));

			List<Utente> utentiInst = utenteService.findByExample(utenteInstance.buildUtenteModel());
			request.setAttribute("utenti_list_attribute", UtenteDTO
					.createUtenteDTOListFromModelList(utentiInst));
			System.out.println(utentiInst);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/search.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/utente/list.jsp").forward(request, response);
	}

}
