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
public class ExecuteVisualizzaIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteVisualizzaIngredienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idIngrediente");

		if (!NumberUtils.isCreatable(idParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		try {
			//posso fare elemento eager e caricare poi le pizze nella view
			Ingrediente ingredienteInstance = ingredienteService.caricaSingoloElemento(Long.parseLong(idParam));

			if (ingredienteInstance == null) {
				request.setAttribute("errorMessage", "Elemento non trovato.");
				request.getRequestDispatcher("ExecuteListIngredienteServlet?operationResult=NOT_FOUND").forward(request,
						response);
				return;
			}

			request.setAttribute("show_ingrediente_attr",
					IngredienteDTO.buildIngredienteDTOFromModel(ingredienteInstance));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/ingrediente/show.jsp").forward(request, response);
	}
}
