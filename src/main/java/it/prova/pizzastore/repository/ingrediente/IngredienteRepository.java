package it.prova.pizzastore.repository.ingrediente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>, CustomIngredienteRepository {

	public List<Ingrediente> findByExample(Ingrediente example);

	@Query("Select i from Ingrediente i left join fetch i.pizze where i.id = ?1")
	Optional<Ingrediente> findOneEager(Long id);
}
