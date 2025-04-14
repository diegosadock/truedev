package br.com.sadock.ecommerce.service.produto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.sadock.ecommerce.model.Categoria;
import br.com.sadock.ecommerce.model.Produto;

public interface IProdutoService {
	
	public Produto cadastrarNovo(Produto novo);
	public Produto alterarProduto(Produto produto);
	public Page<Produto> recuperarTodos(int numPagina);
	public List<Produto> recuperarPorPalavraChave(String palavraChave);
	public Produto buscarPeloId(Integer id);
	public List<Produto> buscarPorCategoria(Categoria categoria);

}
