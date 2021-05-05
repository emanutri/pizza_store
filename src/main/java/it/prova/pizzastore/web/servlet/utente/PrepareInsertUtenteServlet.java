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


@Component
public class PrepareInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RuoloService ruoloService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("ruoli_list_attribute", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllElements()));

		request.setAttribute("insert_utente_attr", UtenteDTO.buildUtenteDTOFromModel(new Utente()));

		request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
	}

}
