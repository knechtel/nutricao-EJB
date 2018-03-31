package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Paciente;

public interface PacienteJpaControllerRemote {
	void create(Paciente paciente);
	
	public List<Paciente> findAll();
	
	public void delete(Paciente paciente);
}