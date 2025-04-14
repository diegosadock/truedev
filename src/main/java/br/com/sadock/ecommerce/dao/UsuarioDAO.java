package br.com.sadock.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.sadock.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByLogin(String login);

}
