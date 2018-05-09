package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.PlanoAlimentarItem;

@Stateless
@Remote(PlanoAlimentarItemJpaControllerRemote.class)
public class PlanoAlimentarItemJpaController implements PlanoAlimentarItemJpaControllerRemote {
	
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(PlanoAlimentarItem planoAlimentarItem) {
		em.persist(planoAlimentarItem);
		em.flush();	
	}

	@Override
	public List<PlanoAlimentarItem> findByPlanoAlimentar(Integer id) {
		return em.createQuery("FROM PlanoAlimentarItem i WHERE i.planoAlimentar.id = :id  ",PlanoAlimentarItem.class).setParameter("id", id).getResultList();
	}

	@Override
	public void delete(PlanoAlimentarItem planoAlimentarItem) {
		// TODO Auto-generated method stub
		
	}

}
