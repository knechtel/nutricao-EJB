package br.com.nutricao.JpaController;

import java.util.List;
import br.com.nutricao.bean.Alimento;
import br.com.nutricao.bean.Paciente;

public interface AlimentoJpaControllerRemote {
	
	void create(br.com.nutricao.bean.Alimento alimento);
	public List<Alimento>findAll();
	public Alimento findById(Integer id);
	public void delete(Alimento alimento);

}
