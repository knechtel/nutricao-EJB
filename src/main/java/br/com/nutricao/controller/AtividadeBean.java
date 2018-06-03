package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.JpaController.ProfissionalSaudeJpaControllerRemote;
import br.com.nutricao.bean.AgendaAtendimento;
import br.com.nutricao.bean.Atividade;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.ProfissionalSaude;


@Named("atividadeBean")
@RequestScoped
public class AtividadeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Atividade atividade;
	private Paciente paciente;
	private ProfissionalSaude profissionalSaude;
	
	private Integer pacienteId;
	private Integer prfissionalSaudeid;
	
	private List<Paciente> listPaciente;
	private List<ProfissionalSaude> listProfissionalSaude;
	private AgendaAtendimento AgendaAtendimento;
	@EJB
	private PacienteJpaControllerRemote pacienteJpa;
	@EJB
	private ProfissionalSaudeJpaControllerRemote profissionalSaudeJpa;
	
	private List<Atividade> listAtividade;
	
	@PostConstruct
	public void init() {
		listPaciente = pacienteJpa.findAll();
		listProfissionalSaude =profissionalSaudeJpa.findAll();
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	
	
	
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String doCad() {
		
		
		return "";
	}

	public List<Paciente> getListPaciente() {
		return listPaciente;
	}

	public void setListPaciente(List<Paciente> listPaciente) {
		this.listPaciente = listPaciente;
	}

	public ProfissionalSaude getProfissionalSaude() {
		return profissionalSaude;
	}

	public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
		this.profissionalSaude = profissionalSaude;
	}

	public Integer getPrfissionalSaudeid() {
		return prfissionalSaudeid;
	}

	public void setPrfissionalSaudeid(Integer prfissionalSaudeid) {
		this.prfissionalSaudeid = prfissionalSaudeid;
	}

	public List<ProfissionalSaude> getListProfissionalSaude() {
		return listProfissionalSaude;
	}

	public void setListProfissionalSaude(List<ProfissionalSaude> listProfissionalSaude) {
		this.listProfissionalSaude = listProfissionalSaude;
	}

	public AgendaAtendimento getAgendaAtendimento() {
		return AgendaAtendimento;
	}

	public void setAgendaAtendimento(AgendaAtendimento agendaAtendimento) {
		AgendaAtendimento = agendaAtendimento;
	}

	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}
	
	
	
}
