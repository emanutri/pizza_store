package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAllElements();

	public Ruolo caricaSingoloElemento(Long id);

	public Ruolo caricaSingoloElementoEager(Long id);

	public void aggiorna(Ruolo filmInstance);

	public void inserisciNuovo(Ruolo filmInstance);

	public void rimuovi(Ruolo filmInstance);

	public List<Ruolo> findByExample(Ruolo example);
}
