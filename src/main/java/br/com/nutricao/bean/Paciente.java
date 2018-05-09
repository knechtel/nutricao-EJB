package br.com.nutricao.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p") })
@Table(name = "paciente")
public class Paciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	private String CPF;
	private String nome;
	private Integer idade;
	private Integer altura;
	private Double peso;
	@JoinTable(name = "paciente_alergico_alimento", joinColumns = {
			@JoinColumn(name = "paciente_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "alimento_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Alimento> listAlimentoAlergico;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Atividade> listAtividade;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Exame> listExame;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<PlanoAlimentar> planos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public List<Alimento> getListAlimentoAlergico() {
		return listAlimentoAlergico;
	}

	public void setListAlimentoAlergico(List<Alimento> listAlimentoAlergico) {
		this.listAlimentoAlergico = listAlimentoAlergico;
	}

	public List<Exame> getListExame() {
		return listExame;
	}

	public void setListExame(List<Exame> listExame) {
		this.listExame = listExame;
	}



	

}
