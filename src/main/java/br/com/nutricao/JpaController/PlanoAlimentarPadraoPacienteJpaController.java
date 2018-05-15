package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.PlanoAlimentar;
import br.com.nutricao.bean.PlanoAlimentarPadraoPaciente;

@Stateless
@Remote(PlanoAlimentarPadraoPacienteJpaControllerRemote.class)
public class PlanoAlimentarPadraoPacienteJpaController implements PlanoAlimentarPadraoPacienteJpaControllerRemote {
	
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(PlanoAlimentarPadraoPaciente planoAlimentar) {
		em.persist(planoAlimentar);
		em.flush();
	}

	@Override
	public List<PlanoAlimentarPadraoPaciente> findByPaciente(Integer id) {
		return em.createQuery("FROM PlanoAlimentarPadraoPaciente p WHERE p.paciente.id = :id  ",PlanoAlimentarPadraoPaciente.class).setParameter("id", id).getResultList();
	}

	@Override
	public void delete(PlanoAlimentarPadraoPaciente planoAlimentar) {
		em.createQuery("DELETE FROM PlanoAlimentarPadraoPaciente WHERE id=" + planoAlimentar.getId()).executeUpdate();
		if (em.contains(planoAlimentar)){
		     em.remove(planoAlimentar);
		}
	}

}
