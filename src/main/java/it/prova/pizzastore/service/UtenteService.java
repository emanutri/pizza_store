package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Utente;

public interface UtenteService {
	public List<Utente> listAllElements();

	public Utente caricaSingoloElemento(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);

	public Utente findByUsernameAndPassword(String username, String password);
}
