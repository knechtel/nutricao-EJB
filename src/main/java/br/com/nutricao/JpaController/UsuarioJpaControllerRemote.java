package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Usuario;

public interface UsuarioJpaControllerRemote {

	void create(br.com.nutricao.bean.Usuario usuario);
	public List<Usuario> findAll();
	public List<Usuario> findAllAdmins();
	public Usuario findByLoginAndSenha(Usuario usuario);
	public void delete(Usuario usuario);

}