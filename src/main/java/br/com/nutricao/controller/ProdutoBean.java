package br.com.nutricao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.ProdutoJpaControllerRemote;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.bean.Produto;

@SessionScoped
@Named("produtoBean")
public class ProdutoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> listProduto;

	@EJB
	private ProdutoJpaControllerRemote produtoController;
	
	

	public String create() {
		produtoController.create(produto);
		listProduto = produtoController.findAll();
		produto = new Produto();

		 return "cadProduto?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		// TODO Auto-generated constructor stub
		listProduto = new ArrayList<Produto>();

		listProduto = produtoController.findAll();
		// In case you're updating an existing entity.
		produto = new Produto();
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String deleteAction(Produto produto) {

		
		listProduto.remove(produto);
		produtoController.delete(produto);
		return null;
	}

}
