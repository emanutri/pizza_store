package it.prova.pizzastore.dto;

import it.prova.pizzastore.model.Cliente;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String via;
	private String citta;
	private String numeroCivico;
	private String telefono;
	private Boolean attivo;
	private List<String> errors = new ArrayList<String>();

	public ClienteDTO(Long id, String nome, String cognome, String via, String citta, String numeroCivico,
			String telefono, Boolean attivo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.citta = citta;
		this.numeroCivico = numeroCivico;
		this.telefono = telefono;
		this.attivo = attivo;
	}

	public ClienteDTO(Long id) {
		this.id = id;
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

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
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

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (StringUtils.isBlank(this.nome))
			validationResult.add("Il campo 'Nome' non può essere vuoto");
		if (StringUtils.isBlank(this.cognome))
			validationResult.add("Il campo 'Cognome' non può essere vuoto");
		if (StringUtils.isBlank(this.via))
			validationResult.add("Il campo 'Via' non può essere vuoto");
		if (StringUtils.isBlank(this.citta))
			validationResult.add("Il campo 'Citta' non può essere vuoto");
		if (StringUtils.isBlank(this.numeroCivico))
			validationResult.add("Il campo 'Numero civico' non può essere vuoto");
		if (StringUtils.isBlank(this.telefono))
			validationResult.add("Il campo 'Telefono' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Cliente buildClienteModel() {
		return new Cliente(this.id, this.nome, this.cognome, this.via, this.citta, this.numeroCivico, this.telefono);
	}

	public static ClienteDTO buildClienteDTOFromModel(Cliente clienteModel) {
		return new ClienteDTO(clienteModel.getId(), clienteModel.getNome(), clienteModel.getCognome(),
				clienteModel.getVia(), clienteModel.getCitta(), clienteModel.getCivico(), clienteModel.getTelefono(),
				clienteModel.getAttivo());
	}

	public static ClienteDTO createClienteDTOFromParams(String idParam, String nomeInputParam, String cognomeInputParam,
			String viaParam, String cittaParam, String numeroCivicoParam, String telefonoParam, String attivoParam) {

		ClienteDTO result = new ClienteDTO(Long.parseLong(idParam), nomeInputParam, cognomeInputParam, viaParam,
				cittaParam, numeroCivicoParam, telefonoParam, Boolean.parseBoolean(attivoParam));
		return result;
	}

	public static List<ClienteDTO> createClienteDTOListFromModelList(List<Cliente> modelListInput) {
		return modelListInput.stream().map(clienteEntity -> {
			return ClienteDTO.buildClienteDTOFromModel(clienteEntity);
		}).collect(Collectors.toList());
	}

}