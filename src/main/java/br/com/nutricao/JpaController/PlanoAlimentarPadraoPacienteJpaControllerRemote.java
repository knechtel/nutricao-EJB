package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.PlanoAlimentarPadraoPaciente;

public interface PlanoAlimentarPadraoPacienteJpaControllerRemote {
	void create(br.com.nutricao.bean.PlanoAlimentarPadraoPaciente planoAlimentar);
	public List<PlanoAlimentarPadraoPaciente>findByPaciente(Integer id);
	public void delete(PlanoAlimentarPadraoPaciente planoAlimentar);
}
