package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.repository.pizza.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository repository;

	@Transactional(readOnly = true)
	public List<Pizza> listAllElements() {
		return (List<Pizza>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Pizza caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Pizza caricaSingoloElementoEager(Long id) {
		return repository.findOneEager(id).orElse(null);

	}

	@Transactional
	public void aggiorna(Pizza pizzaInstance) {
		repository.save(pizzaInstance);
	}

	@Transactional
	public void inserisciNuovo(Pizza pizzaInstance) {
		repository.save(pizzaInstance);

	}

	@Transactional
	public void rimuovi(Pizza pizzaInstance) {
		repository.delete(pizzaInstance);

	}

	@Transactional(readOnly = true)
	public List<Pizza> findByExample(Pizza example) {
		return repository.findByExample(example);
	}

}
