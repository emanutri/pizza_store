package it.prova.pizzastore.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.utility.Utility;

public class OrdineDTO {
	private Long id;
	private Date dataOrdine;
	private String codice;
	private Double costoTotale;
	private Boolean closed;
	private List<String> errors = new ArrayList<String>();

	public OrdineDTO(Long id, Date dataOrdine, String codice, Double costoTotale, Boolean closed) {
		this.id = id;
		this.dataOrdine = dataOrdine;
		this.codice = codice;
		this.costoTotale = costoTotale;
		this.closed = closed;
	}

	public OrdineDTO(Long id, Date dataOrdine, String codice) {
		this.id = id;
		this.dataOrdine = dataOrdine;
		this.codice = codice;
	}

	public OrdineDTO(long id, String codiceParam, boolean parseBoolean) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(Double costoTotale) {
		this.costoTotale = costoTotale;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (this.dataOrdine == null)
			validationResult.add("Il campo 'Data' non può essere vuoto");
		if (StringUtils.isBlank(this.codice))
			validationResult.add("Il campo 'Codice' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Ordine buildOrdineModel() {
		return new Ordine(this.id, this.dataOrdine, this.codice);
	}

	public static OrdineDTO buildClienteDTOFromModel(Ordine ordineModel) {
		return new OrdineDTO(ordineModel.getId(), ordineModel.getData(), ordineModel.getCodice());
	}

	public static OrdineDTO createOrdineDTOFromParams(String idParam, String dataParam, String codiceParam,
			String closedParam) {

		OrdineDTO result = new OrdineDTO(Long.parseLong(idParam), codiceParam, Boolean.parseBoolean(closedParam));
		result.setDataOrdine(Utility.parseDateFromString(dataParam));
		return result;
	}

	public static List<OrdineDTO> createOrdineDTOListFromModelList(List<Ordine> modelListInput) {
		return modelListInput.stream().map(ordineEntity -> {
			return OrdineDTO.buildClienteDTOFromModel(ordineEntity);
		}).collect(Collectors.toList());
	}
}
