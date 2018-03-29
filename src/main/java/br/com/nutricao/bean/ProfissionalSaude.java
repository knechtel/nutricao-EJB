package br.com.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({ @NamedQuery(name = "ProfissionalSaude.findAll", query = "SELECT p FROM ProfissionalSaude p") })
@Table(name = "profissionalSaude")
public class ProfissionalSaude implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1596799321534015424L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String tipo;
	private String nome;
	
	@JoinTable(name = "profissionalSaude_responsavelPor_atividade", 
			joinColumns = { @JoinColumn(name = "profissionalSaude_id", referencedColumnName = "id") 
	}, inverseJoinColumns = {
			@JoinColumn(name = "atividade_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Atividade> listAtividade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Atividade> getListAtividade() {
		return listAtividade;
	}
	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}
	
	

}
