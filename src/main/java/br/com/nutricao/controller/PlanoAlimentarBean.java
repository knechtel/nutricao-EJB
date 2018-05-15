package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.nutricao.bean.Alimento;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.PlanoAlimentar;
import br.com.nutricao.bean.PlanoAlimentarItem;
import br.com.nutricao.bean.PlanoAlimentarPadraoPaciente;
import br.com.nutricao.JpaController.PlanoAlimentarJpaControllerRemote;
import br.com.nutricao.JpaController.PlanoAlimentarPadraoPacienteJpaControllerRemote;
import br.com.nutricao.JpaController.AlimentoJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.JpaController.PlanoAlimentarItemJpaControllerRemote;

@SessionScoped
@Named("planoAlimentarBean")
public class PlanoAlimentarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PacienteJpaControllerRemote pacienteJpaController;
	
	@EJB
	private AlimentoJpaControllerRemote alimentoJpaController;
	
	@EJB
	private PlanoAlimentarJpaControllerRemote planoJpaController;
	
	@EJB
	private PlanoAlimentarItemJpaControllerRemote planoItemJpaController;
	
	@EJB
	private PlanoAlimentarPadraoPacienteJpaControllerRemote planoPadraoJpaController;
	
	private List<Paciente> listPaciente;
	private List<Alimento> listAlimento;
	private List<PlanoAlimentar> listPlanosPadrao;
	
	private PlanoAlimentar plano;
	private PlanoAlimentarItem item;
	private List<PlanoAlimentarItem> listItens;
	private PlanoAlimentarPadraoPaciente planoAlimentarPadraoPaciente;
	
	private Integer idPaciente;
	private Integer idPlanoPadrao;
	private Integer idAlimento;
	
	@PostConstruct
	public void init() {
		this.loadPacientes();
		this.listAlimento = alimentoJpaController.findAll();
		this.setListPlanosPadrao(planoJpaController.findPadroes());
		this.plano = new PlanoAlimentar();
		this.planoAlimentarPadraoPaciente = new PlanoAlimentarPadraoPaciente();
		this.listItens = this.plano.getItens();
		this.item = new PlanoAlimentarItem();
	}
	
	public void loadPacientes() {
		this.listPaciente = pacienteJpaController.findAll();
	}
	
	public String create() {
		if (this.idPlanoPadrao != null && this.idPlanoPadrao != 0) {
			this.createPlanoPadrao();
		} else {
			this.createPlanoNormal();
		}
		this.init();
		return "cadPlanoSuccess.xhtml?faces-redirect=true";
	}
	
	private void createPlanoNormal() {
		if (this.idPaciente != null && this.idPaciente != 0) {
			this.plano.setPaciente(pacienteJpaController.findById(this.idPaciente));
		}
		this.planoJpaController.create(this.plano);
	}
	
	private void createPlanoPadrao() {
		this.planoAlimentarPadraoPaciente.setPaciente(pacienteJpaController.findById(this.idPaciente));
		this.planoAlimentarPadraoPaciente.setPlanoAlimentar(planoJpaController.findById(this.idPlanoPadrao));
		this.planoPadraoJpaController.create(this.planoAlimentarPadraoPaciente);
	}
	
	public void addItem() {
		this.item.setAlimento(this.alimentoJpaController.findById(this.idAlimento));
		this.plano.addItem(this.item);
		this.item = new PlanoAlimentarItem();
		this.listItens = this.plano.getItens();
	}
	
	public void deleteItem(PlanoAlimentarItem item) {
		this.listItens.remove(item);
	}

	public List<Paciente> getListPaciente() {
		return listPaciente;
	}

	public void setListPaciente(List<Paciente> listPaciente) {
		this.listPaciente = listPaciente;
	}

	public List<Alimento> getListAlimento() {
		return listAlimento;
	}

	public void setListAlimento(List<Alimento> listAlimento) {
		this.listAlimento = listAlimento;
	}

	public List<PlanoAlimentar> getListPlanosPadrao() {
		return listPlanosPadrao;
	}

	public void setListPlanosPadrao(List<PlanoAlimentar> listPlanosPadrao) {
		this.listPlanosPadrao = listPlanosPadrao;
	}

	public PlanoAlimentar getPlano() {
		return plano;
	}

	public void setPlano(PlanoAlimentar plano) {
		this.plano = plano;
	}

	public PlanoAlimentarItem getItem() {
		return item;
	}

	public void setItem(PlanoAlimentarItem item) {
		this.item = item;
	}

	public List<PlanoAlimentarItem> getListItens() {
		return listItens;
	}

	public void setListItens(List<PlanoAlimentarItem> listItens) {
		this.listItens = listItens;
	}

	public PlanoAlimentarPadraoPaciente getPlanoAlimentarPadraoPaciente() {
		return planoAlimentarPadraoPaciente;
	}

	public void setPlanoAlimentarPadraoPaciente(PlanoAlimentarPadraoPaciente planoAlimentarPadraoPaciente) {
		this.planoAlimentarPadraoPaciente = planoAlimentarPadraoPaciente;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdPlanoPadrao() {
		return idPlanoPadrao;
	}

	public void setIdPlanoPadrao(Integer idPlanoPadrao) {
		this.idPlanoPadrao = idPlanoPadrao;
	}

	public Integer getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Integer idAlimento) {
		this.idAlimento = idAlimento;
	}
}
