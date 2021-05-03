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
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "via")
	private String via;
	@Column(name = "citta")
	private String citta;
	@Column(name = "civico")
	private String civico;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "attivo")
	private Boolean attivo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Ordine> ordini = new HashSet<Ordine>(0);

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cognome, String via, String citta, String civico, String telefono) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.citta = citta;
		this.civico = civico;
		this.telefono = telefono;
	}

	public Cliente(Long id, String nome, String cognome, String via, String citta, String civico, String telefono,
			Boolean attivo, Set<Ordine> ordini) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.citta = citta;
		this.civico = civico;
		this.telefono = telefono;
		this.attivo = attivo;
		this.ordini = ordini;
	}

	public Cliente(String nome, String cognome, String via, String citta, String civico, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.citta = citta;
		this.civico = civico;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public String toString() {
		return "Cliente: id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", via=" + via + ", citta=" + citta
				+ ", civico=" + civico + ", telefono=" + telefono + ", attivo=" + attivo + ". ";
	}

}
