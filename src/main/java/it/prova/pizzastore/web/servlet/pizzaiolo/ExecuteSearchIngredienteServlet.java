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
public class ExecuteSearchIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteSearchIngredienteServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String codiceParam = request.getParameter("codice");

		try {
			IngredienteDTO ingredienteInstance = IngredienteDTO.createIngredienteDTOFromParams(descrizioneParam,
					prezzoParam, codiceParam);

			request.setAttribute("ingrediente_list_attribute", IngredienteDTO.createIngredienteDTOListFromModelList(
					ingredienteService.findByExample(ingredienteInstance.buildIngredienteModel())));

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/ingrediente/searchIngediente.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/ingrediente/listIngrediente.jsp").forward(request, response);
	}

}
