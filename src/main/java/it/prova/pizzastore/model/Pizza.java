package it.prova.pizzastore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	@Column(name = "prezzoBase")
	private Double prezzoBase;
	@Column(name = "attivo")
	private Boolean attivo;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pizze")
	private Set<Ingrediente> ingredienti = new HashSet<Ingrediente>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pizze")
	private Set<Ordine> ordini = new HashSet<Ordine>(0);

	public Pizza() {
	}

	public Pizza(Long id, String descrizione, String codice, Double prezzoBase, Boolean attivo,
			Set<Ingrediente> ingredienti) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
		this.ingredienti = ingredienti;
	}

	public Pizza(String descrizione, String codice, Double prezzoBase, Boolean attivo) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Double getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(Double prezzoBase) {
		this.prezzoBase = prezzoBase;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	@Override
	public String toString() {
		return "Pizza: id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + ", prezzoBase=" + prezzoBase
				+ ", attivo=" + attivo + ". ";
	}

}
