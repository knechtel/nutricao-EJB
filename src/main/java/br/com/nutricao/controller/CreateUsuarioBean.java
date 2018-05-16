package br.com.nutricao.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import br.com.nutricao.JpaController.UsuarioJpaControllerRemote;

import br.com.nutricao.bean.Usuario;

@Named
@Stateless

public class CreateUsuarioBean {
	@EJB
	private UsuarioJpaControllerRemote usuarioJpaControllerRemote;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		// In case you're updating an existing entity.
		usuario = new Usuario();
	}

	public CreateUsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	public String createUsuario() {
		usuarioJpaControllerRemote.create(usuario);
		return "cadUsrSuccess.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
