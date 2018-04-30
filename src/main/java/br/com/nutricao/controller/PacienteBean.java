package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.ExameJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.Paciente;
@RequestScoped
@Named("pacienteBean")

public class PacienteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PacienteJpaControllerRemote pacienteController;
	@EJB
	private PacienteJpaControllerRemote pacienteJpaController;
	@EJB 
	private PacienteJpaControllerRemote pacienteDelete;

	private List<Paciente> listPaciente;
	
	private List <Exame> listExame;
	
	private Paciente paciente;
	
	@EJB
	ExameJpaControllerRemote exameJpa;

	public PacienteBean() {

	}

	@PostConstruct
	public void init() {
		// TODO Auto-generated constructor stub
		listPaciente = new ArrayList<Paciente>();

		listPaciente = pacienteJpaController.findAll();
		// In case you're updating an existing entity.
		paciente = new Paciente();
		
		
	}

	public String doManterAgenda() {
		return "/cadPaciente.xhtml";
	}

	public String goPrincipal() {
		return "/index.xhtml";
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

	public List<Paciente> getListPaciente() {
		return listPaciente;
	}

	public void setListPaciente(List<Paciente> listPaciente) {
		this.listPaciente = listPaciente;
	}

	public String doHome() {
		return "index.xhtml";
	}

	public String doSomething() {

		System.out.println("DAME");
		return null;
	}

	public String deleteAction(Paciente paciente) {

		System.out.println(paciente.getId() + " ==  delete ss");
		listPaciente.remove(paciente);
		pacienteController.delete(paciente);
		return null;
	}
	
	public String deleteExameAction(Exame exame) {

		System.out.println(exame.getId() + " ==  delete ss");
	
		exameJpa.delete(exame);
		listExame.remove(exame);
		return "/faces/portal/pacienteExames.xhtml";
	}
	
	public String examesAction(Paciente paciente) {

		
	this.paciente = paciente;
	listExame = exameJpa.findByIdPaciente(paciente.getId());
	System.out.println("paciente "+paciente.getId());
	
		return "/faces/portal/pacienteExames.xhtml";
	}
	
	public String update() {
		pacienteController.update(paciente);
		return null;
	}

	public List <Exame> getListExame() {
		return listExame;
	}

	public void setListExame(List <Exame> listExame) {
		this.listExame = listExame;
	}

}