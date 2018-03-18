package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Usuario;

public interface UsuarioControllerRemote {

	void create(br.com.nutricao.bean.Usuario usuario);
	
	public List<Usuario>findAll();
	
	 public Usuario findByLoginAndSenha(Usuario usuario);

}