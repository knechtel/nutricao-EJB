package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.nutricao.bean.Alimento;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.PlanoAlimentar;
import br.com.nutricao.bean.PlanoAlimentarItem;
import br.com.nutricao.JpaController.PlanoAlimentarJpaControllerRemote;
import br.com.nutricao.JpaController.AlimentoJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.JpaController.PlanoAlimentarItemJpaControllerRemote;

@SessionScoped
@Named("planoAlimentarBean")
public class PlanoAlimentarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PacienteJpaControllerRemote pacienteJpaControllerRemote;
	
	@EJB
	private AlimentoJpaControllerRemote alimentoJpaControllerRemote;
	
	@EJB
	private PlanoAlimentarJpaControllerRemote planoAlimentarController;
	
	@EJB
	private PlanoAlimentarItemJpaControllerRemote planoAlimentarItemController;
	
	private List<Paciente> listPaciente;
	private List<Alimento> listAlimento;
	
	private PlanoAlimentar plano;
	private PlanoAlimentarItem item;
	private List<PlanoAlimentarItem> listItens;
	
	private Integer idPaciente;
	private Integer idAlimento;
	
	@PostConstruct
	public void init() {
		this.listPaciente = pacienteJpaControllerRemote.findAll();
		this.listAlimento = alimentoJpaControllerRemote.findAll();
		this.plano = new PlanoAlimentar();
		this.listItens = this.plano.getItens();
		this.item = new PlanoAlimentarItem();
	}
	
	public String create() {
		this.plano.setPaciente(pacienteJpaControllerRemote.findById(this.idPaciente));
		this.planoAlimentarController.create(this.plano);
		this.init();
		return "cadPlanoSuccess?faces-redirect=true";
	}
	
	public void addItem() {
		this.item.setAlimento(this.alimentoJpaControllerRemote.findById(this.idAlimento));
		this.plano.addItem(this.item);
		this.item = new PlanoAlimentarItem();
		this.listItens = this.plano.getItens();
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

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Integer idAlimento) {
		this.idAlimento = idAlimento;
	}
}
