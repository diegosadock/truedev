package br.com.sadock.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sadock.ecommerce.model.Produto;
import br.com.sadock.ecommerce.model.Variante;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {
	
	public List<Variante> findByProduto(Produto p);

}
