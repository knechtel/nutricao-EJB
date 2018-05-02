package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Alimento;

@Stateless
@Remote(AlimentoJpaControllerRemote.class)
public class AlimentoJpaController implements AlimentoJpaControllerRemote {

	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	
	@Override
	public void create(Alimento alimento) {
		em.persist(alimento);
		em.flush();
	}

	@Override
	public List<Alimento> findAll() {
		try {
			@SuppressWarnings("unchecked")
			List<Alimento> list = em.createNamedQuery("Alimento.findAll").getResultList();
			return list;
		} finally {}
	}

	@Override
	public void delete(Alimento alimento) {
		em.createQuery("DELETE FROM Alimento WHERE id=" + alimento.getId()).executeUpdate();
		if (em.contains(alimento)){
		     em.remove(alimento);
		}
	}

}
