package br.com.sadock.ecommerce.service.usuario;

import br.com.sadock.ecommerce.model.Usuario;
import br.com.sadock.ecommerce.security.ECToken;

public interface IUsuarioService {
	
	public Usuario cadastrarNovo(Usuario novo);
	public Usuario alterarDados(Usuario usuario);
	public ECToken fazerLogin(String login, String senha);

}
