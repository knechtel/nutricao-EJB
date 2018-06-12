package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Paciente;

public interface PacienteJpaControllerRemote {
	void create(Paciente paciente);
	public List<Paciente> findAll();
	public void delete(Paciente paciente);
	public Paciente findById(Integer id);
	public Paciente findByCPF(String cpf);
	public void update(Paciente paciente);
	public Paciente findAtividade(Integer id);
}