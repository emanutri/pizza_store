package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Cliente;

public interface ClienteService {
	public List<Cliente> listAllElements();

	public Cliente caricaSingoloElemento(Long id);

	public void aggiorna(Cliente clienteInstance);

	public void inserisciNuovo(Cliente clienteInstance);

	public void rimuovi(Cliente clienteInstance);

}
