package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.IngredienteDTO;

@Component
public class PrepareInsertIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Autowired
//	private IngredienteService ingredienteService;

	public PrepareInsertIngredienteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// List<Ingrediente> ingredienti = ingredienteService.listAllElements();
		// request.setAttribute("ingredienti_list_attribute", ingredienti);
		request.setAttribute("insert_ingrediente_attr", new IngredienteDTO());
		request.getRequestDispatcher("/ingrediente/insert.jsp").forward(request, response);
	}
}
