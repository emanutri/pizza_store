package it.prova.pizzastore.repository.ingrediente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

	public List<Ingrediente> findByExample(Ingrediente example);

}
