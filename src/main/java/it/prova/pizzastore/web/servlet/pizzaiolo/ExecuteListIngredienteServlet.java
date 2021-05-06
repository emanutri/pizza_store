package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.IngredienteDTO;
import it.prova.pizzastore.service.IngredienteService;

@Component
public class ExecuteListIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IngredienteService ingredienteService;

	public ExecuteListIngredienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String operationResult = request.getParameter("operationResult");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
				request.setAttribute("successMessage", "Operazione effettuata con successo");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("NOT_FOUND"))
				request.setAttribute("errorMessage", "Elemento non trovato");

			request.setAttribute("ingrediente_list_attribute",
					IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.setAttribute("ingrediente_list_attribute",
					IngredienteDTO.createIngredienteDTOListFromModelList(ingredienteService.listAllElements()));
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/ingrediente/listIngrediente.jsp").forward(request, response);
	}
}
