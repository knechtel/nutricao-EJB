package br.com.nutricao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.dom4j.io.DocumentSource;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Paciente;

@Named("pacienteBean")
@RequestScoped
public class PacienteBean {
	@EJB
	private PacienteJpaControllerRemote pacienteController;
	@EJB
	private PacienteJpaControllerRemote pacienteJpaController;
	@EJB 
	private PacienteJpaControllerRemote pacienteDelete;

	private List<Paciente> listPaciente;

	private Paciente paciente;

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

}