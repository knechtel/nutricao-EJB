package br.com.nutricao.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "alimento")
@NamedQueries({ @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a ORDER BY a.nome") })
public class Alimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer calorias;
	private String unidadeMedidas;
	
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
	
	public Integer getCalorias() {
		return calorias;
	}
	
	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}
	
	public String getUnidadeMedidas() {
		return unidadeMedidas;
	}
	
	public void setUnidadeMedidas(String unidadeMedidas) {
		this.unidadeMedidas = unidadeMedidas;
	}
}
