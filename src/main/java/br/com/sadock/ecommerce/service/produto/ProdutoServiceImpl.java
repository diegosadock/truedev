package br.com.sadock.ecommerce.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.ProdutoDAO;
import br.com.sadock.ecommerce.model.Categoria;
import br.com.sadock.ecommerce.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDAO dao;
	
	private static final int PAGE_SIZE = 5;
	
	@Override
	public Produto cadastrarNovo(Produto novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return dao.save(produto);
	}

	@Override
	public Page<Produto> recuperarTodos(int numPagina) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(numPagina-1, PAGE_SIZE);
		return dao.findByOrderByNomeAsc(pageable);
	}

	@Override
	public List<Produto> recuperarPorPalavraChave(String palavraChave) {
		// TODO Auto-generated method stub
		return dao.findByNomeContaining(palavraChave);
	}

	@Override
	public Produto buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Produto> buscarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return dao.findByCategoriasContaining(categoria);
	}

}
