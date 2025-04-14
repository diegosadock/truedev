package br.com.sadock.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sadock.ecommerce.model.Categoria;
import br.com.sadock.ecommerce.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {
	
	public List<Produto> findByNomeContaining(String palavra);
	public List<Produto> findByOrderByNomeAsc();
	public List<Produto> findByCategoriasContaining(Categoria categoria);

}
