package br.com.nutricao.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a ")

	
@Table(name = "atividade")
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String protocolo;
	private String descricao;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	@OneToOne(fetch = FetchType.EAGER)
	private AgendaAtendimento agendaAtendimento;
	@ManyToOne(fetch= FetchType.EAGER)
	private Paciente paciente;
	
	
	
	
	public AgendaAtendimento getAgendaAtendimento() {
		return agendaAtendimento;
	}
	public void setAgendaAtendimento(AgendaAtendimento agendaAtendimento) {
		this.agendaAtendimento = agendaAtendimento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public Date getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	
	
	

}
