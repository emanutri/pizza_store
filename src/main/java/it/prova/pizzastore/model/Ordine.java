package it.prova.pizzastore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "data")
	private Date data;
	@Column(name = "prezzo")
	private Double prezzo;
	@Column(name = "codice")
	private String codice;
	@Column(name = "closed")
	private Boolean closed;

	@ManyToMany
	@JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizze = new ArrayList<Pizza>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;

	public Ordine() {
	}

	public Ordine(Long id, Date data, Double prezzo, String codice, Boolean closed, List<Pizza> pizze, Cliente cliente,
			Utente utente) {
		this.id = id;
		this.data = data;
		this.prezzo = prezzo;
		this.codice = codice;
		this.closed = closed;
		this.pizze = pizze;
		this.cliente = cliente;
		this.utente = utente;
	}

	public Ordine(Date data, Double prezzo, String codice, Boolean closed) {
		this.data = data;
		this.prezzo = prezzo;
		this.codice = codice;
		this.closed = closed;
	}

	public Ordine(Long id, Date data, String codice) {
		this.id = id;
		this.data = data;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Ordine: id=" + id + ", data=" + data + ", prezzo=" + prezzo + ", codice=" + codice + ", closed="
				+ closed + ". ";
	}

}
