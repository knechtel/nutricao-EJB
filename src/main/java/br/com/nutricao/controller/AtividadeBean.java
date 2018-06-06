package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.nutricao.JpaController.AgendaAtendimentoJpaControllerRemote;
import br.com.nutricao.JpaController.AtividadeJpaControllerRemote;
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
	private AgendaAtendimento agendaAtendimento;
	@EJB
	private PacienteJpaControllerRemote pacienteJpa;
	@EJB
	private ProfissionalSaudeJpaControllerRemote profissionalSaudeJpa;
	@EJB
	private AtividadeJpaControllerRemote atividadeJpa;
	@EJB
	private AgendaAtendimentoJpaControllerRemote agendaAtendimentoJpa;
	private List<Atividade> listAtividade;
	@EJB
	private AtividadeJpaControllerRemote atividadeCreate;
	@EJB
	private ProfissionalSaudeJpaControllerRemote profissionalSaudeCreate;

	@EJB
	private AgendaAtendimentoJpaControllerRemote agendaAtendimentoCreate;

	@PostConstruct
	public void init() {
		System.out.println();
		atividade = new Atividade();
		agendaAtendimento = new AgendaAtendimento();
		profissionalSaude = new ProfissionalSaude();
		paciente = new Paciente();
		listPaciente = pacienteJpa.findAll();
		listProfissionalSaude = profissionalSaudeJpa.findAll();
		listAtividade = atividadeJpa.findAll();
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
	      
		paciente = pacienteJpa.findById(pacienteId);
		// atividade.setAgendaAtendimento(agendaAtendimento);

		atividade.setPaciente(paciente);
		atividade = atividadeCreate.create(atividade);

		// agendaAtendimento.setAtividade(atividade);
		// agendaAtendimentoCreate.create(agendaAtendimento);
		//

		// atividadeJpa.create(atividade);
		System.out.println("atividade = " + atividade + " atividade.id = " + atividade.getId());
		System.out.println("atividade = " + atividade + " atividade.horaInicio = " + atividade.getDataHoraInicio());

		listAtividade = new ArrayList<Atividade>();

		listAtividade.add(atividade);

		
		profissionalSaude = profissionalSaudeJpa.findByID(prfissionalSaudeid);
		profissionalSaude.setListAtividade(listAtividade);

		System.out.println("profissionalSaude  = " + profissionalSaude.getId());
		
		profissionalSaudeJpa.merge(profissionalSaude);
		// profissionalSaudeCreate.merge(profissionalSaude);
		// atividadeJpa.create(atividade);

		
		// pacienteJpa.update(paciente);
		// atividade.setAgendaAtendimento(agendaAtendimento);

		// agendaAtendimentoJpa.create(agendaAtendimento);//

		// if (listAtividade != null) {
		// listAtividade.add(atividade);
		// } else {
		// listAtividade = new ArrayList<Atividade>();
		// listAtividade.add(atividade);
		// }
		// List<Atividade> swapListAtividade = null;
		//
		// if (profissionalSaude.getListAtividade() == null) {
		// swapListAtividade = new ArrayList<Atividade>();
		// swapListAtividade.add(atividade);
		// profissionalSaude.setListAtividade(listAtividade);
		//
		// // persisit
		// }
	
		return "cadAtividadeSuccess.xhtml";
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
		return agendaAtendimento;
	}

	public void setAgendaAtendimento(AgendaAtendimento agendaAtendimento) {
		this.agendaAtendimento = agendaAtendimento;
	}

	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}

}
