package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.nutricao.JpaController.UsuarioControllerRemote;
import br.com.nutricao.bean.Usuario;

@Stateless
@SessionScoped
@Named("usuarioBean")

public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UsuarioControllerRemote usuarioJPAcontroller;

	private Usuario usuario;
	
	

	private Boolean log;

	
	private String email;
	private String password;


	

	public String doTest() {
		usuario = new Usuario();
		usuario.setNome(email);
		usuario.setPassword(password);
		Usuario u = usuarioJPAcontroller.findByLoginAndSenha(usuario);
		
		
	
	   
	 
	    
		if (u != null) {
		log=true;
			return "/portal/index.jsf";
			
		} else {
			log=false;
			return null;
		}
	}
	
	public String doAgenda() {
		log=true;
		return "/portal/manterAgenda.jsf";
	}

	public Boolean isLoggedIn() {
		return log;
	}
	public Usuario getUsuario() {
		return (Usuario) usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
	
}
