package br.com.nutricao.JpaController;

import java.util.List;
import br.com.nutricao.bean.PlanoAlimentar;

public interface PlanoAlimentarJpaControllerRemote {
	void create(br.com.nutricao.bean.PlanoAlimentar planoAlimentar);
	public List<PlanoAlimentar>findByPaciente(Integer id);
	public void delete(PlanoAlimentar planoAlimentar);
}
