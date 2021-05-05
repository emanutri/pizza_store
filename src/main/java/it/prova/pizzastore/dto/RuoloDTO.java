package it.prova.pizzastore.dto;

import it.prova.pizzastore.model.Ruolo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RuoloDTO {
	private Long id;
	private String descrizione;
	private String codice;

	// questo serve per la validazione quindi la stampa degli errori in pagina
	// non riguarda il binding a differenza dei campi sopra....ecco un buon motivo
	// per
	// disaccoppiare con un DTO...
	private List<String> errors = new ArrayList<String>();

	public RuoloDTO() {
	}

	public RuoloDTO(Long id, String descrizione, String codice) {
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public RuoloDTO(String descrizioneInputParam, String codiceInputParam) {
		this.descrizione = descrizioneInputParam;
		this.codice = codiceInputParam;
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

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Ruolo buildRuoloModel() {
		return new Ruolo(this.id, this.descrizione, this.codice);
	}

	public static RuoloDTO buildRuoloDTOFromModel(Ruolo ruoloModel) {
		RuoloDTO result = new RuoloDTO(ruoloModel.getId(), ruoloModel.getDescrizione(), ruoloModel.getCodice());

		return result;
	}

	public static RuoloDTO createRuoloDTOFromParams(String descrizioneInputParam, String codiceInputParam) {

		RuoloDTO result = new RuoloDTO(descrizioneInputParam, codiceInputParam);

		return result;
	}

	public static List<RuoloDTO> createRuoloDTOListFromModelList(List<Ruolo> modelListInput) {
		return modelListInput.stream().map(RuoloEntity -> {
			return RuoloDTO.buildRuoloDTOFromModel(RuoloEntity);
		}).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuoloDTO other = (RuoloDTO) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
