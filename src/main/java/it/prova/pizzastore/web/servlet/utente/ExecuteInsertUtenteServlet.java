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
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;

@Component
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String passwordRepeatParam = request.getParameter("passwordRepeat");
		String[] rouloParam = request.getParameterValues("ruolo.id");

		
		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromInsertParams(usernameParam, passwordParam, nomeParam,
				cognomeParam, RuoloDTO.createRuoloDTOListFromModelList(ruoloService.findByArrayIdParam(rouloParam)));

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			if(UtenteDTO.validateUtenteDTOBean(utenteInstance, passwordRepeatParam)) {
				utenteService.inserisciNuovo(utenteInstance.buildUtenteModel());
				
				
			}else{
				request.setAttribute("errorMessage", "Attenzione le password non combaciano.");
				request.setAttribute("insert_utente_attr", utenteInstance);
				request.setAttribute("ruoli_list_attribute", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllElements()));

				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath() + "/utente/ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
