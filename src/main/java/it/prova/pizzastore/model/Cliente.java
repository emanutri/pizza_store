package it.prova.pizzastore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private Double nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "via")
	private String via;
	@Column(name = "citta")
	private String citta;
	@Column(name = "civico")
	private Integer civico;
	@Column(name = "telefono")
	private Integer telefono;
	@Column(name = "attivo")
	private Boolean attivo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Ordine> ordini = new HashSet<Ordine>(0);
}
