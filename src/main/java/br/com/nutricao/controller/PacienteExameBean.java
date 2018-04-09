package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Exame;

@Named("pacienteExameBean")
public class PacienteExameBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PacienteJpaControllerRemote pacienteJpa;
	
	private List<Exame> listExame;
	
	@Inject
	PacienteBean pacienteBean;
	
	@PostConstruct
	public void init() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(pacienteBean.getPaciente().getAltura());
		
		//listExame = pacienteJpa.findExames(pacienteBean.getPaciente().getId()).getListExame();
	
	}

	public List<Exame> getListExame() {
		return listExame;
	}

	public void setListExame(List<Exame> listExame) {
		this.listExame = listExame;
	}


}
