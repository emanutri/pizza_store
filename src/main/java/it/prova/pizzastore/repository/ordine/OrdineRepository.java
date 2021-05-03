package it.prova.pizzastore.repository.ordine;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long> {
	@Query("Select o from Ordine o left join fetch o.pizze left join fetch o.cliente left join fetch o.utente where o.id = ?1")
	Optional<Ordine> findOneEager(Long id);
}
