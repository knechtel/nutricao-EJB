package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.PlanoAlimentar;

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
	public PlanoAlimentar findById(Integer id) {
		return em.find(PlanoAlimentar.class, id);
	}

	@Override
	public List<PlanoAlimentar> findByPaciente(Integer id) {
		return em.createQuery("FROM PlanoAlimentar p WHERE p.paciente.id = :id", PlanoAlimentar.class).setParameter("id", id).getResultList();
	}
	
	@Override
	public List<PlanoAlimentar> findPadroes() {
		return em.createQuery("FROM PlanoAlimentar p WHERE p.paciente.id = NULL", PlanoAlimentar.class).getResultList();
	}

	@Override
	public void delete(PlanoAlimentar planoAlimentar) {
		em.createQuery("DELETE FROM PlanoAlimentar WHERE id=" + planoAlimentar.getId()).executeUpdate();
		if (em.contains(planoAlimentar)){
		     em.remove(planoAlimentar);
		}
	}

}
