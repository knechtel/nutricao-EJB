package br.com.nutricao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Paciente;

@RequestScoped
@Named("cadastroPacienteBean")
public class CadastroPacienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PacienteJpaControllerRemote pacienteController;
	
	private Paciente paciente;
	
	@PostConstruct
	public void init() {
		paciente = new Paciente();
	}
	
	public String create() {
		pacienteController.create(paciente);
		return "cadPacienteSuccess.xhtml";
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}

