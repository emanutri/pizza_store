package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.repository.cliente.ClienteRepository;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listAllElements() {
		return (List<Cliente>) repository.findAll();
	}

	@Override
	public Cliente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Override
	public void inserisciNuovo(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Override
	public void rimuovi(Cliente clienteInstance) {
		repository.delete(clienteInstance);

	}

}
