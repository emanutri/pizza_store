package it.prova.pizzastore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private Double prezzo;
	@Column(name = "codice")
	private String codice;

	@ManyToMany
	@JoinTable(name = "ingrediente_pizza", joinColumns = @JoinColumn(name = "ingrediente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizze = new ArrayList<Pizza>(0);

	public Ingrediente() {
	}

	public Ingrediente(Long id, String descrizione, Double prezzo, String codice, List<Pizza> pizze) {
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = codice;
		this.pizze = pizze;
	}

	public Ingrediente(String descrizione, Double prezzo, String codice) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = codice;
	}

	public Ingrediente(Long id, String descrizione, Double prezzo, String codice) {
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = codice;
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

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	@Override
	public String toString() {
		return "Ingrediente: id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", codice=" + codice
				+ ". ";
	}

}
