package br.com.sadock.ecommerce.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.UsuarioDAO;
import br.com.sadock.ecommerce.model.Usuario;
import br.com.sadock.ecommerce.security.ECToken;
import br.com.sadock.ecommerce.security.ECTokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario cadastrarNovo(Usuario novo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(novo.getSenha());
		novo.setSenha(novaSenha);
		
		return dao.save(novo);
	}

	@Override
	public Usuario alterarDados(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(usuario.getSenha());
		usuario.setSenha(novaSenha);
		
		return dao.save(usuario);
	}

	@Override
	public ECToken fazerLogin(String login, String senha) {
		Usuario usuario = dao.findByLogin(login);
		
		if (usuario != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(senha, usuario.getSenha())) {
				return ECTokenUtil.encode(usuario);
			}
		}
		
		return null;
	}

}
