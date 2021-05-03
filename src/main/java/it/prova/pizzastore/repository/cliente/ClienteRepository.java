package it.prova.pizzastore.repository.cliente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	public List<Cliente> findByExample(Cliente example);

}
