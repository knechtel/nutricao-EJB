package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

import br.com.nutricao.JpaController.ExameJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.Paciente;

@Named("exameBean")
@RequestScoped
public class ExameBean implements Serializable {

	@EJB
	private ExameJpaControllerRemote exameJpaControllerRemote;
	@EJB
	private PacienteJpaControllerRemote pacienteJpaControllerRemote;

	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	private List<Paciente> listPaciente;
	private Exame exame;

	private Integer idPaciente;

	@PostConstruct
	public void init() {
		// TODO Auto-generated constructor stub
		listPaciente = new ArrayList<Paciente>();

		listPaciente = pacienteJpaControllerRemote.findAll();
		// In case you're updating an existing entity.
		System.out.println(listPaciente.size() + " []  lista paciente");
		
		exame = new Exame();

	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Paciente> getListPaciente() {
		listPaciente = new ArrayList<Paciente>();

		listPaciente = pacienteJpaControllerRemote.findAll();

		System.out.println("sim aquiiiiii >>>>>");
		return listPaciente;
	}

	public void setListPaciente(List<Paciente> listPaciente) {
		this.listPaciente = listPaciente;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String persist() {
		exame.setPaciente(pacienteJpaControllerRemote.findById(idPaciente));
		exameJpaControllerRemote.create(exame);
		return null;
	}

}
