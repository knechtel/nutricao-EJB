package br.com.nutricao.controller;


import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Paciente;
@RequestScoped
@Named("cadastroPacienteBean")
public class CadastroPacienteBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PacienteJpaControllerRemote pacienteController;
	private Paciente paciente;
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	@PostConstruct
	public void init() {
		// TODO Auto-generated constructor stub
	
		paciente = new Paciente();
		
		
	}
	public String create() {
		pacienteController.create(paciente);
		return "cadPacienteSuccess.xhtml";
	}
}

