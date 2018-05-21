package br.com.nutricao.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.JpaController.UsuarioJpaControllerRemote;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.Usuario;

@Named
@Stateless
public class CreateUsuarioBean {
	@EJB
	private UsuarioJpaControllerRemote usuarioController;
	
	@EJB
	private PacienteJpaControllerRemote pacienteController;

	private Usuario usuario;
	private String cpf;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public String createUsuario() {
		Paciente p = this.pacienteController.findByCPF(this.cpf);
		if (p == null) {
			return "error.xhtml";
		}
		this.usuario.setPaciente(p);
		this.usuarioController.create(usuario);
		return "success.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
