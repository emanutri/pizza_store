package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.repository.cliente.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<Cliente> listAllElements() {
		return (List<Cliente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Cliente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Transactional
	public void inserisciNuovo(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Transactional
	public void rimuovi(Cliente clienteInstance) {
		repository.delete(clienteInstance);

	}

}
