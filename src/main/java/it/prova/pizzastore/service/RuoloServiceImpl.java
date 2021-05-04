package it.prova.pizzastore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.repository.ruolo.RuoloRepository;

@Service
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloRepository repository;

	@Transactional(readOnly = true)
	public List<Ruolo> listAllElements() {
		return (List<Ruolo>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Ruolo caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		repository.save(ruoloInstance);
	}

	@Transactional
	public void inserisciNuovo(Ruolo ruoloInstance) {
		repository.save(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Ruolo ruoloInstance) {
		repository.delete(ruoloInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) {
		return repository.findByDescrizioneAndCodice(descrizione, codice);
	}

	@Transactional(readOnly = true)
	public Set<Ruolo> findByArrayIdParam(String[] ids) {
		Set<Ruolo> ruoli = new HashSet<>();
		if (ids != null && ids.length > 0) {
			for (String ruoloItem : ids) {
				ruoli.add(repository.findById(Long.parseLong(ruoloItem)).get());
			}
		}
		return ruoli;
	}
}
