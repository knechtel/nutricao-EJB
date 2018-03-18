package br.com.nutricao.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Paciente;

@Stateless
@SessionScoped
@Named("manterAgenda")

public class ManterAgendaBean {
	@EJB
	private PacienteJpaControllerRemote pacienteController;

	
	private Paciente paciente;

	@PostConstruct
	public void init() {
		// In case you're updating an existing entity.
		paciente = new Paciente();
	}

	public String doManterAgenda() {
		return "/cadPaciente.xhtml";
	}

	public String goPrincipal() {
		return "/index.jsf";
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String create() {
		pacienteController.create(paciente);
		return "cadPacienteSuccess.xhtml";
	}

}
