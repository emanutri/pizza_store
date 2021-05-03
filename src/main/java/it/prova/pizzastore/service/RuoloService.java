package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAllElements();

	public Ruolo caricaSingoloElemento(Long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisciNuovo(Ruolo ruoloInstance);

	public void rimuovi(Ruolo ruoloInstance);

	public Ruolo cercaPerDescrizioneECodice(String string, String string2);

}
