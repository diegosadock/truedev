package br.com.sadock.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.sadock.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
	
	public Cliente findByTelefone(String telefone);
	

}
