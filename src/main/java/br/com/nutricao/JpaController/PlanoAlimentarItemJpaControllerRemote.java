package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.PlanoAlimentarItem;

public interface PlanoAlimentarItemJpaControllerRemote {
	void create(br.com.nutricao.bean.PlanoAlimentarItem planoAlimentarItem);
	public List<PlanoAlimentarItem>findByPlanoAlimentar(Integer id);
	public void delete(PlanoAlimentarItem planoAlimentarItem);
}
