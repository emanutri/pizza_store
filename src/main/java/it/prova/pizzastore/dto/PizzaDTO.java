package it.prova.pizzastore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Pizza;

public class PizzaDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private Double prezzoBase;
	private Integer attivo;
	private List<String> errors = new ArrayList<String>();

	public PizzaDTO(Long id, String descrizione, String codice, Integer prezzoBase) {

	}

	public PizzaDTO(long id, String descrizioneParam, String codiceParam, double parseDouble) {

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

	public Integer getAttivo() {
		return attivo;
	}

	public void setAttivo(Integer attivo) {
		this.attivo = attivo;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (StringUtils.isBlank(this.descrizione))
			validationResult.add("Il campo 'Descrizione' non può essere vuoto");
		if (StringUtils.isBlank(this.codice))
			validationResult.add("Il campo 'Codice' non può essere vuoto");
		if (this.prezzoBase == null)
			validationResult.add("Il campo 'Prezzo base' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Pizza buildPizzaModel() {
		return new Pizza(this.id, this.descrizione, this.codice, this.prezzoBase);
	}

	public static PizzaDTO buildPizzaDTOFromModel(Pizza pizzaModel) {
		return new PizzaDTO(pizzaModel.getId(), pizzaModel.getDescrizione(), pizzaModel.getCodice(),
				pizzaModel.getPrezzoBase());
	}

	public static PizzaDTO createPizzaDTOFromParams(String idParam, String descrizioneParam, String codiceParam,
			String prezzoBase) {

		PizzaDTO result = new PizzaDTO(Long.parseLong(idParam), descrizioneParam, codiceParam,
				Double.parseDouble(prezzoBase));
		return result;
	}

	public static List<PizzaDTO> createPizzaDTOListFromModelList(List<Pizza> modelListInput) {
		return modelListInput.stream().map(pizzaEntity -> {
			return PizzaDTO.buildPizzaDTOFromModel(pizzaEntity);
		}).collect(Collectors.toList());
	}
}
