package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Pizza;

public interface PizzaService {
	public List<Pizza> listAllElements();

	public Pizza caricaSingoloElemento(Long id);

	public Pizza caricaSingoloElementoEager(Long id);

	public void aggiorna(Pizza filmInstance);

	public void inserisciNuovo(Pizza filmInstance);

	public void rimuovi(Pizza filmInstance);

	public List<Pizza> findByExample(Pizza example);
}
