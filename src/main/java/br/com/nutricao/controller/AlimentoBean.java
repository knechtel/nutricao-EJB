package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.AlimentoJpaControllerRemote;
import br.com.nutricao.bean.Alimento;

@RequestScoped
@Named("alimentoBean")
public class AlimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Alimento alimento;
	private List<Alimento> listAlimento;

	@EJB
	private AlimentoJpaControllerRemote alimentoController;

	public String create() {
		alimentoController.create(alimento);
		listAlimento = alimentoController.findAll();
		alimento = new Alimento();

		return "cadAlimento?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		listAlimento = new ArrayList<Alimento>();
		listAlimento = alimentoController.findAll();
		alimento = new Alimento();
	}

	public List<Alimento> getListAlimento() {
		return listAlimento;
	}

	public void setListAlimento(List<Alimento> listAlimento) {
		this.listAlimento = listAlimento;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public String deleteAction(Alimento alimento) {
		listAlimento.remove(alimento);
		alimentoController.delete(alimento);
		return null;
	}
	
}
