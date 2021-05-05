package it.prova.pizzastore.repository.utente;

import java.util.List;

import it.prova.pizzastore.model.Utente;

public interface CustomUtenteRepository {

	public List<Utente> findByExample(Utente example);

	public Long countByAdmin();

}
