package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.ExameJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.JpaController.PlanoAlimentarJpaControllerRemote;
import br.com.nutricao.JpaController.PlanoAlimentarPadraoPacienteJpaControllerRemote;
import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.PlanoAlimentar;
import br.com.nutricao.bean.PlanoAlimentarPadraoPaciente;

@SessionScoped
@Named("siteBean")
public class SiteBean implements Serializable {
	
	@Inject
	UsuarioBean usuarioBean;

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PacienteJpaControllerRemote pacienteController;
	
	@EJB 
	private PlanoAlimentarJpaControllerRemote planoController;
	
	@EJB 
	private PlanoAlimentarPadraoPacienteJpaControllerRemote planoPadraoController;
	
	@EJB
	private ExameJpaControllerRemote exameController;

	private List<Exame> listExames;
	private List<PlanoAlimentar> listPlanos;
	
	private Paciente paciente;
	private PlanoAlimentar plano;

	@PostConstruct
	public void init() {
		this.paciente = this.pacienteController.findById(usuarioBean.getIdPaciente());
		this.loadPlanos();
		this.listExames = exameController.findByIdPaciente(paciente.getId());
	}
	
	private void loadPlanos() {
		this.listPlanos = planoController.findByPaciente(paciente.getId());
		List<PlanoAlimentarPadraoPaciente> maisPlanos = planoPadraoController.findByPaciente(this.paciente.getId());
		for (PlanoAlimentarPadraoPaciente p : maisPlanos) {
			this.listPlanos.add(p.getPlanoAlimentar());
		}
	}
	
	public String viewPlanoAction(PlanoAlimentar plano) {
		this.plano = plano;
		return "viewPlano.xhtml";
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PlanoAlimentar getPlano() {
		return plano;
	}

	public void setPlano(PlanoAlimentar plano) {
		this.plano = plano;
	}

	public List <Exame> getListExames() {
		return listExames;
	}

	public void setListExames(List <Exame> listExames) {
		this.listExames = listExames;
	}

	public List<PlanoAlimentar> getListPlanos() {
		return listPlanos;
	}

	public void setListPlanos(List<PlanoAlimentar> listPlanos) {
		this.listPlanos = listPlanos;
	}

}