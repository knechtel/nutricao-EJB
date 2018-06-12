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
	
	@Override
	public List<Paciente> findAll() {
		List<Paciente> listPaciente = em.createNamedQuery("Paciente.findAll",Paciente.class).getResultList();
		return listPaciente;
	}
	
	@Override
	public void delete(Paciente paciente) {
		em.createQuery("DELETE FROM Paciente p WHERE id=" + paciente.getId()).executeUpdate();
		if (em.contains(paciente)){
		     em.remove(paciente);
		}
	}
	
	public Paciente findById(Integer id) {
		return em.find(Paciente.class, id);
	}
	
	@Override
	public Paciente findByCPF(String cpf) {
		List<Paciente> list = em.createNamedQuery("Paciente.findByCPF", Paciente.class)
				.setParameter("cpf", cpf)
				.setMaxResults(1)
				.getResultList();
		if (list == null || list.size() == 0)
			return null;
		else
			return list.get(0);
	}
	
	public void update(Paciente paciente) {
		em.merge(paciente);
	}
	
	public Paciente findAtividade(Integer id) {
	
		Paciente pt = em.createNamedQuery("Paciente.findAtividade",Paciente.class).setParameter("id", id).getSingleResult();
	
		return pt;
	}
}
