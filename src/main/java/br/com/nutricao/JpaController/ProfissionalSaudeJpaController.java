package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.ProfissionalSaude;

@Stateless

@Remote(ProfissionalSaudeJpaControllerRemote.class)
public class ProfissionalSaudeJpaController implements ProfissionalSaudeJpaControllerRemote {
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(ProfissionalSaude profissionalSaude) {
		// TODO Auto-generated method stub
		em.persist(profissionalSaude);
	}

	public List<ProfissionalSaude> findAll() {
		List<ProfissionalSaude> listPaciente = em.createNamedQuery("ProfissionalSaude.findAll", ProfissionalSaude.class)
				.getResultList();
		return listPaciente;
	}

	public void delete(ProfissionalSaude profissionalSaude) {
		em.createQuery("DELETE FROM ProfissionalSaude p  WHERE id=" + profissionalSaude.getId()).executeUpdate();
		if (em.contains(profissionalSaude)) {
			em.remove(profissionalSaude);
		}
	}
}
