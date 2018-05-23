package br.com.nutricao.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plano_alimentar_padrao_paciente")
public class PlanoAlimentarPadraoPaciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private PlanoAlimentar planoAlimentar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PlanoAlimentar getPlanoAlimentar() {
		return planoAlimentar;
	}

	public void setPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		this.planoAlimentar = planoAlimentar;
	}
}
