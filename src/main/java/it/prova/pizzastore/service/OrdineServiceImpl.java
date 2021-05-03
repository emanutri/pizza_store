package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore.model.Ingrediente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.ordine.OrdineRepository;

public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Override
	public List<Ordine> listAllElements() {
		return (List<Ordine>) repository.findAll();
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Ordine caricaSingoloElementoEager(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Ordine ordineInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Ordine ordineInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ordine> findByExample(Ordine example) {
		// TODO Auto-generated method stub
		return null;
	}

}
