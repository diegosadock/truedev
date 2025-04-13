package br.com.sadock.ecommerce.service.categoria;

import java.util.List;

import br.com.sadock.ecommerce.model.Categoria;

public interface ICategoriaService {
	
	public Categoria criarNova(Categoria nova);
	public Categoria alterar(Categoria categoria);
	public List<Categoria> listarTudo();
	public void apagarCategoria(Integer id);

}
