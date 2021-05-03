package it.prova.pizzastore;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;

@SpringBootApplication
public class PizzastoreApplication implements CommandLineRunner {

	@Autowired
	private RuoloService ruoloServiceInstance;
	@Autowired
	private UtenteService utenteServiceInstance;

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ADMIN_ROLE") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ADMIN_ROLE"));
		}
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Pizzaiolo User", "PIZZAIOLO_ROLE") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Pizzaiolo User", "PIZZAIOLO_ROLE"));
		}
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Fattorino User", "FATTORINO_ROLE") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Fattorino User", "FATTORINO_ROLE"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("admin", "admin") == null) {
			Utente admin = new Utente("admin", "admin", "Mario", "Rossi", new Date());
			admin.setStato(StatoUtente.ATTIVO);
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ADMIN_ROLE"));
			utenteServiceInstance.inserisciNuovo(admin);
//			utenteServiceInstance.aggiungiRuolo(admin,
//					ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("user", "user") == null) {
			Utente admin = new Utente("user", "user", "Antonio", "Verdi", new Date());
			admin.setStato(StatoUtente.ATTIVO);
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
			utenteServiceInstance.inserisciNuovo(admin);
//			utenteServiceInstance.aggiungiRuolo(admin,
//					ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("fattorino", "fattorino") == null) {
			Utente admin = new Utente("fattorino", "fattorino", "Simona", "Ventura", new Date());
			admin.setStato(StatoUtente.ATTIVO);
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Fattorino User", "FATTORINO_ROLE"));
			utenteServiceInstance.inserisciNuovo(admin);
//			utenteServiceInstance.aggiungiRuolo(admin,
//					ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
		}

	}
}
