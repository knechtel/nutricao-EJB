package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.UsuarioJpaControllerRemote;
import br.com.nutricao.bean.Usuario;

@RequestScoped
@Named("createUsuarioAdminBean")
public class CreateUsuarioAdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioJpaControllerRemote usuarioController;

	private Usuario usuario;
	private List<Usuario> listUsuario;

	@PostConstruct
	public void init() {
		listUsuario = usuarioController.findAllAdmins();
		usuario = new Usuario();
	}

	public String create() {
		usuario.setTipo(Usuario.TIPO_ADMIN);
		usuarioController.create(usuario);
		usuario = new Usuario();
		listUsuario = usuarioController.findAllAdmins();
		return "cadUsuario.xhtml?faces-redirect=true";
	}
	
	public String delete(Usuario usuario) {
		listUsuario.remove(usuario);
		usuarioController.delete(usuario);
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

}
