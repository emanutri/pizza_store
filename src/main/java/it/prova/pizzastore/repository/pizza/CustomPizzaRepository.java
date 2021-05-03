package it.prova.pizzastore.repository.pizza;

import java.util.List;

import it.prova.pizzastore.model.Pizza;

public interface CustomPizzaRepository {

	public List<Pizza> findByExample(Pizza example);

}
