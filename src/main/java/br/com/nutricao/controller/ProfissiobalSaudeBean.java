package br.com.nutricao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.nutricao.JpaController.ProfissionalSaudeJpaControllerRemote;
import br.com.nutricao.bean.Paciente;
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

	@PostConstruct
	public void init() {
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
		return "cadPrSaude.xhtml?faces-redirect=true";
	}

	public List<ProfissionalSaude> getListProfissionalSaude() {
		return listProfissionalSaude;
	}

	public void setListProfissionalSaude(List<ProfissionalSaude> listProfissionalSaude) {
		this.listProfissionalSaude = listProfissionalSaude;
	}
	
	public String deleteAction(ProfissionalSaude profissionaSaude) {
		listProfissionalSaude.remove(profissionaSaude);
		profissionalSaudeRemote.delete(profissionaSaude);
		return null;
	}

}
