package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Exame;

public interface ExameJpaControllerRemote {
	public void create(Exame exame);
	public List<Exame> findByIdPaciente(Integer id);
	public void delete(Exame exame) ;
}
