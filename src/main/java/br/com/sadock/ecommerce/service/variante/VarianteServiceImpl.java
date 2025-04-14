package br.com.sadock.ecommerce.service.variante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.VarianteDAO;
import br.com.sadock.ecommerce.model.Produto;
import br.com.sadock.ecommerce.model.Variante;

@Component
public class VarianteServiceImpl implements IVarianteService {
	
	@Autowired
	private VarianteDAO dao;

	@Override
	public Variante adicionarNova(Variante nova) {
		// TODO Auto-generated method stub
		return dao.save(nova);
	}

	@Override
	public Variante alterarDados(Variante variante) {
		// TODO Auto-generated method stub
		return dao.save(variante);
	}

	@Override
	public List<Variante> recuperarPorProduto(Produto p) {
		// TODO Auto-generated method stub
		return dao.findByProduto(p);
	}

	@Override
	public Variante recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
