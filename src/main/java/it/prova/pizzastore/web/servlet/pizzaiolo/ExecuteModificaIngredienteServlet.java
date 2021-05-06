package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.service.IngredienteService;

@Component
public class ExecuteModificaIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteModificaIngredienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String codiceParam = request.getParameter("codice");

		try {

			long idIngrediente = Long.parseLong(idParam);

			IngredienteDTO ingredienteDaValidare = IngredienteDTO.createIngredienteDTOFromParams(descrizioneParam,
					prezzoParam, codiceParam);
			ingredienteDaValidare.setId(idIngrediente);
			ingredienteDaValidare.validate();

			if (ingredienteDaValidare.hasErrors()) {
				request.setAttribute("ingredienteDaModificare", ingredienteDaValidare);
				request.getRequestDispatcher("/ingrediente/edit.jsp").forward(request, response);
				return;
			}

			ingredienteService.aggiorna(ingredienteDaValidare.buildIngredienteModel());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListIngredienteServlet?operationResult=SUCCESS");
	}

}
