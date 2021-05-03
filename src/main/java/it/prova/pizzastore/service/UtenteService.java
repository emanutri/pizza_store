package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Utente;

public interface UtenteService {
	public List<Utente> listAllElements();

	public Utente caricaSingoloElemento(Long id);

	public Utente caricaSingoloElementoEager(Long id);

	public void aggiorna(Utente filmInstance);

	public void inserisciNuovo(Utente filmInstance);

	public void rimuovi(Utente filmInstance);

	public List<Utente> findByExample(Utente example);
}
