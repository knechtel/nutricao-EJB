package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Atividade;

public interface AtividadeJpaControllerRemote {

	public Atividade create(Atividade atividade);
	
	public List<Atividade> findAll();
	
	
	
}
