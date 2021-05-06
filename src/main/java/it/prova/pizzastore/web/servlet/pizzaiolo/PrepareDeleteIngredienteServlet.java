package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.service.IngredienteService;


@Component
public class PrepareDeleteIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;
	
	public PrepareDeleteIngredienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParameter = request.getParameter("idIngrediente");

		if (!NumberUtils.isCreatable(idParameter)) {

			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/ingrediente/list.jsp").forward(request, response);
			return;
		}

		try {
			Ingrediente ingredienteInstance = ingredienteService.caricaSingoloElemento(Long.parseLong(idParameter));
			
			request.setAttribute("ingrediente_delete", IngredienteDTO.buildIngredienteDTOFromModel(ingredienteInstance));

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/ingrediente/delete.jsp");
		rd.forward(request, response);
	}

}
