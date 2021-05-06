package it.prova.pizzastore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.model.Ingrediente;

public class IngredienteDTO {
	private Long id;
	private String descrizione;
	private Double prezzo;
	private String codice;
	private List<String> errors = new ArrayList<String>();

	public IngredienteDTO(Long id, String descrizione, Double prezzo, String codice) {
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = codice;
	}

	public IngredienteDTO(String descrizione, Double prezzo, String codice) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = codice;
	}

	public IngredienteDTO(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public IngredienteDTO() {
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
		if (this.prezzo == null)
			validationResult.add("Il campo 'Prezzo' non può essere vuoto");
		if (StringUtils.isBlank(this.codice))
			validationResult.add("Il campo 'Codice' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Ingrediente buildIngredienteModel() {
		return new Ingrediente(this.id, this.descrizione, this.prezzo, this.codice);
	}

	public static IngredienteDTO buildIngredienteDTOFromModel(Ingrediente ingredienteModel) {
		return new IngredienteDTO(ingredienteModel.getId(), ingredienteModel.getDescrizione(),
				ingredienteModel.getPrezzo(), ingredienteModel.getCodice());
	}

	public static IngredienteDTO createIngredienteDTOFromParams(String descrizioneParam, String prezzoParam,
			String codiceParam) {

		IngredienteDTO result = null;

		if (NumberUtils.isCreatable(prezzoParam)) {
			result = new IngredienteDTO(descrizioneParam, Double.parseDouble(prezzoParam), codiceParam);

		} else {
			result = new IngredienteDTO(descrizioneParam, codiceParam);
		}
		return result;
	}

	public static List<IngredienteDTO> createIngredienteDTOListFromModelList(List<Ingrediente> modelListInput) {
		return modelListInput.stream().map(ingredienteEntity -> {
			return IngredienteDTO.buildIngredienteDTOFromModel(ingredienteEntity);
		}).collect(Collectors.toList());
	}
}
