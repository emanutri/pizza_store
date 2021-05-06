package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.repository.ingrediente.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService {

	@Autowired
	private IngredienteRepository repository;

	@Transactional(readOnly = true)
	public List<Ingrediente> listAllElements() {
		return (List<Ingrediente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Ingrediente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public Ingrediente caricaSingoloElementoConPizze(Long id) {
		return repository.findOneEager(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Ingrediente ingredienteInstance) {
		repository.save(ingredienteInstance);
	}

	@Transactional
	public void inserisciNuovo(Ingrediente ingredienteInstance) {
		repository.save(ingredienteInstance);
	}

	@Transactional
	public void rimuovi(Ingrediente ingredienteInstance) {
		repository.delete(ingredienteInstance);
	}

	@Transactional(readOnly = true)
	public List<Ingrediente> findByExample(Ingrediente example) {
		return repository.findByExample(example);
	}

}
