package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.PlanoAlimentar;

public interface PlanoAlimentarJpaControllerRemote {
	void create(br.com.nutricao.bean.PlanoAlimentar planoAlimentar);
	public PlanoAlimentar findById(Integer id);
	public List<PlanoAlimentar>findByPaciente(Integer id);
	public List<PlanoAlimentar>findPadroes();
	public void delete(PlanoAlimentar planoAlimentar);
}
