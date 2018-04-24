package br.com.nutricao.JpaController;

import java.util.List;

import br.com.nutricao.bean.Produto;

public interface ProdutoJpaControllerRemote {
	public void create(br.com.nutricao.bean.Produto produto);
	public List<Produto> findAll();
	public void delete(Produto produto) ;
}
