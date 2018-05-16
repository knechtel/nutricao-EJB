package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.PlanoAlimentarJpaControllerRemote;
import br.com.nutricao.bean.PlanoAlimentar;

@RequestScoped
@Named("planoPadraoBean")
public class PlanoPadraoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PlanoAlimentarJpaControllerRemote planoController;
	
	private PlanoAlimentar plano;
	private List<PlanoAlimentar> listPlanos;
	
	@PostConstruct
	public void init() {
		this.listPlanos = new ArrayList<PlanoAlimentar>();
		this.listPlanos = planoController.findPadroes();
		this.plano = new PlanoAlimentar();
	}
	
	public String view(PlanoAlimentar plano) {
		// TODO
		return null;
	}
	
	public String delete(PlanoAlimentar plano) {
		this.listPlanos.remove(plano);
		this.planoController.delete(plano);
		return null;
	}

	public PlanoAlimentar getPlano() {
		return plano;
	}

	public void setPlano(PlanoAlimentar plano) {
		this.plano = plano;
	}

	public List<PlanoAlimentar> getListPlanos() {
		return listPlanos;
	}

	public void setListPlanos(List<PlanoAlimentar> listPlanos) {
		this.listPlanos = listPlanos;
	}

}
