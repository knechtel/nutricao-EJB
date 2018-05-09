package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.PlanoAlimentar;
import br.com.nutricao.bean.PlanoAlimentarItem;

@Stateless
@Remote(PlanoAlimentarJpaControllerRemote.class)
public class PlanoAlimentarJpaController implements PlanoAlimentarJpaControllerRemote {
	
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(PlanoAlimentar planoAlimentar) {
		em.persist(planoAlimentar);
		em.flush();
	}

	@Override
	public List<PlanoAlimentar> findByPaciente(Integer id) {
		return em.createQuery("FROM PlanoAlimentar p WHERE p.paciente.id = :id  ",PlanoAlimentar.class).setParameter("id", id).getResultList();
	}

	@Override
	public void delete(PlanoAlimentar planoAlimentar) {
		// TODO Auto-generated method stub
		
	}

}
