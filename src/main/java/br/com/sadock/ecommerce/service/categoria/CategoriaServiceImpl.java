package br.com.sadock.ecommerce.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.CategoriaDAO;
import br.com.sadock.ecommerce.model.Categoria;

@Component
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaDAO dao;

	@Override
	public Categoria criarNova(Categoria nova) {
		// TODO Auto-generated method stub
		return dao.save(nova);
	}

	@Override
	public Categoria alterar(Categoria categoria) {
		// TODO Auto-generated method stub
		return dao.save(categoria);
	}

	@Override
	public List<Categoria> listarTudo() {
		return dao.findAllByOrderByNomeAsc();
	}

	@Override
	public void apagarCategoria(Integer id) {
		dao.deleteById(id);
		
	}

}
