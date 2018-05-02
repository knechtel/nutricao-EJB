package br.com.nutricao.JpaController;

import java.util.List;
import br.com.nutricao.bean.Alimento;

public interface AlimentoJpaControllerRemote {
	
	void create(br.com.nutricao.bean.Alimento alimento);
	public List<Alimento>findAll();
	public void delete(Alimento alimento);

}
