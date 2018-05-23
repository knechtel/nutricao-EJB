package br.com.nutricao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "plano_alimentar")
public class PlanoAlimentar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	
	private String nome;
	private String descricao;
	
	@ManyToOne(optional = true)
	private Paciente paciente;
	
	@OneToMany(mappedBy = "planoAlimentar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("dia, turno, opcao")
	private List<PlanoAlimentarItem> itens;
	
	public PlanoAlimentar() {
		this.itens = new ArrayList<PlanoAlimentarItem>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public List<PlanoAlimentarItem> getItens() {
		return itens;
	}

	public void setItens(List<PlanoAlimentarItem> itens) {
		this.itens = itens;
	}

	public void addItem(PlanoAlimentarItem item) {
		item.setPlanoAlimentar(this);
		this.itens.add(item);
	}

}
