package it.prova.pizzastore.repository.ingrediente;

import java.util.List;

import it.prova.pizzastore.model.Ingrediente;

public interface CustomIngredienteRepository {

	public List<Ingrediente> findByExample(Ingrediente example);

}
