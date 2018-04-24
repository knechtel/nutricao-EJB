package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.Produto;
import br.com.nutricao.bean.Usuario;

@Stateless
@Remote(ProdutoJpaControllerRemote.class)
public class ProdutoJpaController implements ProdutoJpaControllerRemote {

	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	public void create(br.com.nutricao.bean.Produto produto) {
		// TODO Auto-generated method stub
		em.persist(produto);
		em.flush();
	}
	
	public List<Produto> findAll() {
		try {
			@SuppressWarnings("unchecked")
			List<Produto> list = em.createNamedQuery("Produto.findAll").getResultList();
			return list;
		} finally {

		}
	}
	
	public void delete(Produto produto) {
		em.createQuery("DELETE FROM Exame e WHERE id=" + produto.getId()).executeUpdate();
		if (em.contains(produto)){
		     em.remove(produto);
		}
	}
}
