package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.ProfissionalSaude;

public interface ProfissionalSaudeJpaControllerRemote {

	void merge(ProfissionalSaude profissionalSaude);
	
	void create(ProfissionalSaude profissionalSaude);
	
	public List<ProfissionalSaude> findAll();
	
	public void delete(ProfissionalSaude profissionalSaude);
	
	public ProfissionalSaude findByID(Integer id);
}