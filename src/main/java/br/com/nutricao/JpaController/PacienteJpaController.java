package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Paciente;

@Stateless

@Remote(PacienteJpaControllerRemote.class)
public class PacienteJpaController implements PacienteJpaControllerRemote {
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		em.persist(paciente);
	}

	public List<Paciente> findAll() {
		List<Paciente> listPaciente = em.createNamedQuery("Paciente.findAll").getResultList();
		return listPaciente;
	}
	@Override
	public void delete(Paciente paciente) {
		em.createQuery("DELETE FROM Paciente p WHERE id=" + paciente.getId()).executeUpdate();
		if (em.contains(paciente)){
		     em.remove(paciente);
		}
	}

}
