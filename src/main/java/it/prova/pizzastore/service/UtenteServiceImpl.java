package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.repository.utente.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository repository;

	@Transactional(readOnly = true)
	public List<Utente> listAllElements() {
		return (List<Utente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);

	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		repository.save(utenteInstance);
	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		repository.save(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		repository.delete(utenteInstance);
	}

	@Transactional
	public List<Utente> findByExample(Utente example) {
		return repository.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Utente findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return repository.findByUsernameAndPasswordAndStato(username, password, StatoUtente.ATTIVO);
	}
}
