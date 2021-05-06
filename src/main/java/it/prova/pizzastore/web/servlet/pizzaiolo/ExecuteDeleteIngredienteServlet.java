package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;

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
public class ExecuteDeleteIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteDeleteIngredienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idDeleteInput");

		if (!NumberUtils.isCreatable(idParam)) {
			request.setAttribute("errorMessage", "Attenzione, si è verificato un errore!");
			request.getRequestDispatcher("ingrediente/search.jsp").forward(request, response);
			return;
		}

		try {

			Ingrediente ingredienteInstance = ingredienteService.caricaSingoloElementoConPizze(Long.parseLong(idParam));
			ingredienteService.rimuovi(ingredienteInstance);

			request.setAttribute("listaIngredientiAttribute",
					IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));
			request.setAttribute("successMessage", "Operazione eseguita con successo!");

		} catch (RuntimeException e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Impossibile eliminare ingrediente, perchè ha pizze associate.");
			request.setAttribute("ingredienti_list_attribute",
					IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));
			request.getRequestDispatcher("ingrediente/list.jsp").forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("ingrediente/list.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(
				request.getContextPath() + "/pizzaiolo/ExecuteListIngredienteServlet?operationResult=SUCCESS");
	}

}
