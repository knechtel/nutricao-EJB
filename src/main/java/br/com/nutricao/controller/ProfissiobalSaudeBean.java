package br.com.nutricao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.ProfissionalSaudeJpaControllerRemote;
import br.com.nutricao.bean.ProfissionalSaude;


@Named
@RequestScoped
public class ProfissiobalSaudeBean {
	@EJB
	private ProfissionalSaudeJpaControllerRemote profissionalSaudeRemote;
	@EJB
	private ProfissionalSaudeJpaControllerRemote profissionalSaudeRemoteList;
	private ProfissionalSaude profissionalSaude;
	private List<ProfissionalSaude> listProfissionalSaude;
	
	public ProfissiobalSaudeBean() {
	
		
	}

	@PostConstruct
	public void init() {
		// In case you're updating an existing entity.
		profissionalSaude = new ProfissionalSaude();
		listProfissionalSaude = new ArrayList<ProfissionalSaude>();
		listProfissionalSaude = profissionalSaudeRemoteList.findAll();
	}


	public ProfissionalSaude getProfissionalSaude() {
		return profissionalSaude;
	}


	public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
		this.profissionalSaude = profissionalSaude;
	}
	
	public String create() {
		
		profissionalSaudeRemote.create(profissionalSaude);
		return "cadPrSuccess.xhtml";
	}

	public List<ProfissionalSaude> getListProfissionalSaude() {
		return listProfissionalSaude;
	}

	public void setListProfissionalSaude(List<ProfissionalSaude> listProfissionalSaude) {
		this.listProfissionalSaude = listProfissionalSaude;
	}
	
	

}
