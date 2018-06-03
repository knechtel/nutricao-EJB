package br.com.nutricao.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.UsuarioJpaControllerRemote;
import br.com.nutricao.bean.Usuario;

@SessionScoped
@Named("usuarioBean")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioJpaControllerRemote usuarioJPAcontroller;

	private Boolean log = false; // is logged in or not
	
	private Usuario usuario;
	
	private Integer idPaciente;
	private String nome;
	private String email;
	private String password;
	private Integer tipo;

	public String doLogin() {
		this.usuario = new Usuario();
		this.usuario.setEmail(email);
		this.usuario.setPassword(password);
		this.password = null;
		Usuario u = this.usuarioJPAcontroller.findByLoginAndSenha(this.usuario);
		if (u != null) {
			this.log = true;
			this.nome = u.getNome();
			this.tipo = u.getTipo();
			if (this.isTipoAdmin()) {
				return "/portal/index.xhtml?faces-redirect=true";
			} else {
				this.idPaciente = u.getPaciente().getId();
				return "/site/index.xhtml?faces-redirect=true";
			}
		} else {
			this.log = false;
			return null;
		}
	}
	
	public String doLogout() {
		this.usuario = null;
		this.log = false;
		return "/index.xhtml?faces-redirect=true";
	}

	public String createUsuario() {
		usuario.setTipo(Usuario.TIPO_NORMAL);
		this.usuarioJPAcontroller.create(usuario);
		return null;
	}

	public Boolean isLoggedIn() {
		return this.log;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean isTipoNormal() {
		return this.tipo == Usuario.TIPO_NORMAL;
	}
	
	public Boolean isTipoAdmin() {
		return this.tipo == Usuario.TIPO_ADMIN;
	}
}
