package it.prova.pizzastore.web.servlet.pizzaiolo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
public class PrepareSearchIngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchIngredienteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/ingrediente/searchIngrediente.jsp").forward(request, response);
	}

}
