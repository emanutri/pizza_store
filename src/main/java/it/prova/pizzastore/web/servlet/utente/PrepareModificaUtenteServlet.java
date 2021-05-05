package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.RuoloDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;


@Component
public class PrepareModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	public PrepareModificaUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idUtente");

		try {
			Utente daModificare = utenteService.caricaUtenteEager(Long.parseLong(idParam));
			request.setAttribute("utenteDaModificare",UtenteDTO.buildUtenteDTOFromModel(daModificare));
			
			List<Ruolo> ruoli = ruoloService.listAllElements();
			request.setAttribute("ruoli_list_attribute", RuoloDTO.createRuoloDTOListFromModelList(ruoli));
			
			RequestDispatcher rd = request.getRequestDispatcher("/utente/edit.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
	}

}
