package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.repository.ingrediente.IngredienteRepository;

public class IngredienteServiceImpl implements IngredienteService {

	@Autowired
	private IngredienteRepository repository;

	@Override
	public List<Ingrediente> listAllElements() {
		return (List<Ingrediente>) repository.findAll();
	}

	@Override
	public Ingrediente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(Ingrediente ingredienteInstance) {
		repository.save(ingredienteInstance);
	}

	@Override
	public void inserisciNuovo(Ingrediente ingredienteInstance) {
		repository.save(ingredienteInstance);
	}

	@Override
	public void rimuovi(Ingrediente ingredienteInstance) {
		repository.delete(ingredienteInstance);
	}

	@Override
	public List<Ingrediente> findByExample(Ingrediente example) {
		return repository.findByExample(example);
	}

}
